package com.example.demo.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.AcompteCalculDTO;
import com.example.demo.dtos.FormulaireRequest;
import com.example.demo.dtos.RequestCaluclDTO;
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
    LocalDateTime DATE=formulaire.getExercicedu().withDayOfMonth(1);
	
	if(obligation.getId()==1) {
		return DATE.plusMonths(3).minusSeconds(1);
	}
	else if(obligation.getId()==2){
		return DATE.plusMonths(6).minusSeconds(1);
	}
	else if(obligation.getId()==3) {
		return DATE.plusMonths(9).minusSeconds(1);
	}
	return DATE.plusMonths(12).minusSeconds(1);
}

public AcompteCalculDTO calcul(RequestCaluclDTO calcul) {
	AcompteCalculDTO acomptecalculDTO=new AcompteCalculDTO();
	
	

	acomptecalculDTO.setMontantprincipal(calcul.getMontantref()/4);
	double montantduprincipal=acomptecalculDTO.getMontantprincipal()+calcul.getMontantTotalImpu();
	acomptecalculDTO.setMontantduprincipal( montantduprincipal);
	   double daysdiffence = ChronoUnit.DAYS.between(calcul.getDateexegibilité(),LocalDate.now());
	   float monthsDifference=ChronoUnit.MONTHS.between(calcul.getDateexegibilité(),LocalDate.now());
		Period period=Period.between( calcul.getDateexegibilité(),LocalDate.now());
	   
	
	   if( monthsDifference==0 && daysdiffence<=30 ) {
		   acomptecalculDTO.setMontantpenalite((montantduprincipal*5)/100);
		   acomptecalculDTO.setMontantmajorations((montantduprincipal*5)/100);
		   acomptecalculDTO.setMontanttotal(acomptecalculDTO.getMontantduprincipal()+acomptecalculDTO.getMontantmajorations()+acomptecalculDTO.getMontantpenalite());
		return acomptecalculDTO;
		   
		   
		  
			
		}
		else if(monthsDifference>0 ) {
			double montant= (montantduprincipal*5)/100;
			 acomptecalculDTO.setMontantpenalite((montantduprincipal*10)/100);
			if(period.getDays()==0) {
			
			
		
				montant=montant+(montantduprincipal*0.5*(monthsDifference-1))/100;
				acomptecalculDTO.setMontantmajorations(montant);
				
			
			

			}
			
			else if(period.getDays()>0) {
				
			
				
					montant=montant+(montantduprincipal*0.5*monthsDifference)/100;
					acomptecalculDTO.setMontantmajorations(acomptecalculDTO.getMontantmajorations()+montant);
					
				
				
			}
		}
	   
	   acomptecalculDTO.setMontanttotal(acomptecalculDTO.getMontantduprincipal()+acomptecalculDTO.getMontantmajorations()+acomptecalculDTO.getMontantpenalite());
		   
	return acomptecalculDTO;
}



}
