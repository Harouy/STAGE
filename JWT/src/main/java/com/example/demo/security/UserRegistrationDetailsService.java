package com.example.demo.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Utilisateur;

import com.example.demo.repositories.UtilisateurRepository;

@Service
@RequiredArgsConstructor
public class UserRegistrationDetailsService implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur personne = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Cette utilisateur n'existe pas"));
        UserRegistrationDetails user = new UserRegistrationDetails(personne);
        return user;
    }
}
