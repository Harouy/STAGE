package com.example.demo.security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import com.example.demo.dtos.UtilisateurDTO;
import com.example.demo.entities.Type_profil;
import com.example.demo.entities.Utilisateur;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.mappers.UtilisateurMapper;

import com.example.demo.repositories.UtilisateurRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UtilisateurMapper personneMapper;
    private final UtilisateurRepository personneRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UtilisateurDTO personneDTO) throws PersonneNotFoundException{
        String login = personneDTO.getLogin();
        Optional<Utilisateur> existingPersonne = personneRepository.findByLogin(login);
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
                        request.getLogin(),
                        request.getPassword()
                )
        );
        Utilisateur personne = personneRepository.findByLogin(request.getLogin()).orElseThrow();
        /*List<Type_profil> roles = personne.getType_profils();
        List<String> roleNames = roles.stream()
                .map(Type_profil::getType)
                .collect(Collectors.toList());*/
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("idPersonne", personne.getId());
        extraClaims.put("nom", personne.getPrenom());
       /* extraClaims.put("roles", roleNames);*/
     
        UserDetails userDetails = new UserRegistrationDetails(personne);
        String jwtToken = jwtService.generateToken(extraClaims, userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}