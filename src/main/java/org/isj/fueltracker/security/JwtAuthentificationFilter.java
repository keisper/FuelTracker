package org.isj.fueltracker.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Classe permettant de générer le token
 */
public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    /**
     *
     * @author groupe_service
     * @param authenticationManager
     */
    public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * charger les infos de l'utilisateur et créer le token de l'utilisateur de la base de données
     * @author groupe_service
     * @param request
     * @param response
     * @return Authentication
     * @throws AuthenticationException
     */
    //fonction utilisée quand on tente de se connecter
    //elle est déclenchée quand on effectue une requête POST à /login
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            //ici on prend les paramètres de connexion venant de la requete et on les mappe à un objet LoginViewModel
        LoginViewModel infosLogin = null;
        try {
            infosLogin = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //on crée un token de connexion, NB: ceci n'est pas le JWT
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                Objects.requireNonNull(infosLogin).getUsername(),
                infosLogin.getPassword(),
                new ArrayList<>()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return authentication;

    }

    /**
     * @author groupe_service
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    //fonction utilisée quand l'authentification a réussi, on construit le token JWT
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
      UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();

      //On crée le jwt token
      String token = JWT.create()
              .withSubject(userPrincipal.getUsername())
              .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.DATE_EXPIRATION))
              .sign(Algorithm.HMAC512(JwtProperties.SECRET));
        //on ajoute ce token à l'en tête de la requête http
      response.addHeader(JwtProperties.HEADER_STRING,JwtProperties.TOKEN_PREFIX + token);

      //response.addHeader("User", userPrincipal.toString());
    }
}
