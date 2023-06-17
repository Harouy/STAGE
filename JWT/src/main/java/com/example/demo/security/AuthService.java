package com.example.demo.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import com.example.demo.dtos.UtilisateurDTO;

import com.example.demo.entities.Utilisateur;

import com.example.demo.mappers.UtilisateurMapper;

import com.example.demo.repositories.UtilisateurRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UtilisateurMapper personneMapper;
    private final UtilisateurRepository personneRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UtilisateurDTO personneDTO){
        String email = personneDTO.getEmail();
        Optional<Utilisateur> existingPersonne = personneRepository.findByEmail(email);
        if(existingPersonne.isPresent() ) {
            String errorMessage = "ce compte avec cet email existe déjà";
            return AuthenticationResponse.builder()
                    .token(null) // Set token to null since it's an error response
                    .errorMessage(errorMessage)
                    .build();
        }
        Utilisateur personne = personneMapper.fromPersonneDTO(personneDTO);
        Utilisateur savedPersonne = personneRepository.save(personne);
        UserDetails userDetails = new UserRegistrationDetails(savedPersonne);
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("idPersonne", savedPersonne.getId());
        extraClaims.put("nom", savedPersonne.getPrenom());
       
        String jwtToken = jwtService.generateToken(extraClaims,userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Utilisateur personne = personneRepository.findByEmail(request.getEmail()).orElseThrow();
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("idPersonne", personne.getId());
        extraClaims.put("nom", personne.getPrenom());
     
        UserDetails userDetails = new UserRegistrationDetails(personne);
        String jwtToken = jwtService.generateToken(extraClaims, userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}