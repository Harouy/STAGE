package com.example.demo.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.FormulaireRequest;
import com.example.demo.dtos.VersementDTO;
import com.example.demo.entities.Contribuable;
import com.example.demo.entities.Obligation_fiscale;
import com.example.demo.entities.Versement;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.mappers.VersementMapper;
import com.example.demo.repositories.ContribuableRepository;
import com.example.demo.repositories.ObligationRepository;
import com.example.demo.repositories.UtilisateurRepository;
import com.example.demo.repositories.VersementReposiotry;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VersementService {
	private final UtilisateurRepository utilisateurrepository ;
	private final VersementReposiotry versementrepository;
	private final ContribuableRepository contribuablereposiotry;
	private final ContribuableService contribuableservice;
	private final VersementMapper versementmapper;
	private final ObligationRepository obligationrepository;

public List<VersementDTO> getversements( long idContribuables) throws PersonneNotFoundException{
	Contribuable contribuable=contribuableservice.getContribuable(idContribuables);
	List<Versement> versements=versementrepository.findByContribuable(contribuable);
	 List<VersementDTO> versementDTOS = versements.stream()
             .map(versement->{
				try {
					return versementmapper.fromversement(versement);
				} catch (PersonneNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			})
             .collect(Collectors.toList());
	 return  versementDTOS;
	
	
	
	
	
}
public LocalDateTime getDateexegibilité( FormulaireRequest   formulaire) {
    
	
	Obligation_fiscale obligation=obligationrepository.findByType(formulaire.getType());
	if(obligation.getId()==1) {
		return formulaire.getExercicedu().plusMonths(3).minusSeconds(1);
	}
	else if(obligation.getId()==2){
		return formulaire.getExercicedu().plusMonths(6).minusSeconds(1);
	}
	else if(obligation.getId()==3) {
		return formulaire.getExercicedu().plusMonths(9).minusSeconds(1);
	}
	return formulaire.getExercicedu().plusMonths(12).minusSeconds(1);
}


}
