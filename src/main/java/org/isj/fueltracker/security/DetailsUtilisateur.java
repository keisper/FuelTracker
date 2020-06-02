package org.isj.fueltracker.security;


import org.isj.fueltracker.entities.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * classe qui permet d'extraire des informations d'un utilisateur
 * UserDetails est une interface utilisée par spring security
 */
public class DetailsUtilisateur implements UserDetails {
    private Utilisateur utilisateur;

    public DetailsUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //on récupère le role d'un utilisateur
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + utilisateur.getRoles());
        authorities.add(grantedAuthority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return utilisateur.getMdp();
    }

    @Override
    public String getUsername() {
        return utilisateur.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return utilisateur.isActive();
    }
}
