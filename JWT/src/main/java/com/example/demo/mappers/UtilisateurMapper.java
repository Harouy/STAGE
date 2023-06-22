package com.example.demo.mappers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Services.ContribuableService;
import com.example.demo.dtos.UtilisateurDTO;
import com.example.demo.entities.Contribuable;
import com.example.demo.entities.Utilisateur;
import com.example.demo.exceptions.PersonneNotFoundException;

@Service
@RequiredArgsConstructor
public class UtilisateurMapper {
    private final PasswordEncoder passwordEncoder;
    private final ContribuableService contribuableservice;

    public UtilisateurDTO fromPersonne(Utilisateur personne) {
        UtilisateurDTO personneDTO = new UtilisateurDTO();
        BeanUtils.copyProperties(personne,personneDTO);
        Contribuable contribuable=personne.getContribuable();
        personneDTO.setId_contribuable(contribuable.getID());;
        return personneDTO;
    }

    public Utilisateur fromPersonneDTO(UtilisateurDTO personneDTO) throws PersonneNotFoundException {
        Utilisateur personne= new Utilisateur();
        BeanUtils.copyProperties(personneDTO,personne);
        personne.setMdp(passwordEncoder.encode(personneDTO.getMdp()));
        Contribuable contribuable=  contribuableservice.getContribuableBYpersonne(personneDTO.getId_contribuable());
        personne.setContribuable(contribuable);
       
        return personne;
    }

}
