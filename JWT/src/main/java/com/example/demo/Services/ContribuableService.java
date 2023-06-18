package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Contribuable;
import com.example.demo.entities.Utilisateur;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.repositories.ContribuableRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContribuableService {
private final ContribuableRepository contribuablerepository;
private final UtilisateurService utilisateurservice;
public Contribuable getContribuable(Long id) throws PersonneNotFoundException {
	Utilisateur utilisateur=utilisateurservice.getUtilisateur(id);
	Contribuable contribuable=utilisateur.getContribuable();
	return contribuable;
	
	
	
}
}
