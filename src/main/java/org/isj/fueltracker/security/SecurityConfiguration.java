package org.isj.fueltracker.security;

import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Classe utilisée pour paramétrer spring security
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DetailsUtilisateurService detailsUtilisateurService;
    private UtilisateurRepository utilisateurRepository;

    public SecurityConfiguration(DetailsUtilisateurService detailsUtilisateurService, UtilisateurRepository utilisateurRepository) {
        this.detailsUtilisateurService = detailsUtilisateurService;
        this.utilisateurRepository = utilisateurRepository;
    }

    //pour paramétrer le gestionnaire d'authentification
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    //pour filtrer les requetes http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthentificationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(),utilisateurRepository))
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/api/**").authenticated();
    }

    //pour définir l'authentification basée sur un BD
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(detailsUtilisateurService);
        return daoAuthenticationProvider;
    }

    // pour définir comment les mots de passe seront hachés
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
