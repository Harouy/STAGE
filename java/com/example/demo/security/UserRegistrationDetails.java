package com.example.demo.security;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.Type_profil;
import com.example.demo.entities.Utilisateur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserRegistrationDetails implements UserDetails{
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserRegistrationDetails(Utilisateur personne) {
        this.username = personne.getLogin();
        this.password = personne.getMdp();
        /* List<GrantedAuthority> authorityList = Arrays.stream(personne.getType().toString().split(""))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());*/
      
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
  

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return true;
    }
}
