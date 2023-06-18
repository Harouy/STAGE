package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Utilisateur;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.repositories.ContribuableRepository;
import com.example.demo.repositories.UtilisateurRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilisateurService {
private final UtilisateurRepository utilisateurRepository ;
public Utilisateur getUtilisateur(Long id) throws PersonneNotFoundException  {
Utilisateur utilisateur=utilisateurRepository.findById(id).orElseThrow(() -> new PersonneNotFoundException("Ce personne n'existe pas"));
return utilisateur;
}
}
