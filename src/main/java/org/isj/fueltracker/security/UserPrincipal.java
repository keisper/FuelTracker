package org.isj.fueltracker.security;

import org.isj.fueltracker.entities.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    Utilisateur utilisateur;

    public UserPrincipal(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        //liste des roles
        this.utilisateur.getRoleList().forEach(r -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + r);
            grantedAuthorities.add(grantedAuthority);
        });
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.utilisateur.getPassword();
    }

    @Override
    public String getUsername() {
        return this.utilisateur.getUsername();
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
        return true ;
    }
}
