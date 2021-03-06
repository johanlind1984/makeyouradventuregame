package com.johanlind.makeyouradventure.Services;

import com.johanlind.makeyouradventure.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class AdventurePrincipalUser implements UserDetails {

    private User user;

    public AdventurePrincipalUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> grantedAuthority = new ArrayList<>();
        grantedAuthority.add(new SimpleGrantedAuthority(user.getAuthority().getAuthorityName()));
        return grantedAuthority;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.isEnabled();
    }
}
