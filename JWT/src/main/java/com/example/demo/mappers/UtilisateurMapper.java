package com.example.demo.mappers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.dtos.UtilisateurDTO;

import com.example.demo.entities.Utilisateur;

@Service
@RequiredArgsConstructor
public class UtilisateurMapper {
    private final PasswordEncoder passwordEncoder;

    public UtilisateurDTO fromPersonne(Utilisateur personne) {
        UtilisateurDTO personneDTO = new UtilisateurDTO();
        BeanUtils.copyProperties(personne,personneDTO);
        return personneDTO;
    }

    public Utilisateur fromPersonneDTO(UtilisateurDTO personneDTO) {
        Utilisateur personne= new Utilisateur();
        BeanUtils.copyProperties(personneDTO,personne);
        personne.setMdp(passwordEncoder.encode(personneDTO.getMdp()));
        return personne;
    }

}
