package com.nemk.educator.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nemk.educator.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class JwtUser implements UserDetails {

    private String id;
    private String username;
    private String password;
    private User user;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;


    public JwtUser(String id, String username, String password, User user, Collection<? extends GrantedAuthority> authorities, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.user = user;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
