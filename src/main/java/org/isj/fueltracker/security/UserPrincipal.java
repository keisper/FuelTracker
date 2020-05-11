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

    /**
     *
     * @param utilisateur
     */
    public UserPrincipal(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     *
     * @return Collection<? extends GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

             //liste des roles
            String r = this.utilisateur.getRoles();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + r);
            grantedAuthorities.add(grantedAuthority);

        return grantedAuthorities;
    }

    /**
     *
     * @return String
     */
    @Override
    public String getPassword() {
        return this.utilisateur.getPassword();
    }

    /**
     *
     * @return String
     */
    @Override
    public String getUsername() {
        return this.utilisateur.getUsername();
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean isEnabled() {
        return true ;
    }
}
