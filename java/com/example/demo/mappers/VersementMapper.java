package com.example.demo.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Services.ContribuableService;
import com.example.demo.Services.UtilisateurService;
import com.example.demo.dtos.UtilisateurDTO;
import com.example.demo.dtos.VersementDTO;
import com.example.demo.entities.Utilisateur;
import com.example.demo.entities.Versement;
import com.example.demo.exceptions.PersonneNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VersementMapper {
	private final  UtilisateurService utilisateurservice;
	private final ContribuableService contribuableservice;

@SuppressWarnings("deprecation")
public VersementDTO fromversement(Versement versement) throws PersonneNotFoundException {
	VersementDTO versementDTO=new VersementDTO();
	Utilisateur utilisateur =utilisateurservice.getUtilisateur(versement.getIdmodificateur());
	 BeanUtils.copyProperties(versement,versementDTO);
	 versementDTO.setObligation_fiscale(versement.getObligation_fiscale().getType());
	 versementDTO.setEtat((versement.getEtat_versement()).getEtat());
	 versementDTO.setModificateur(utilisateur.getNom());
	 versementDTO.setExfiscal(versement.getExercice_fical_du().toString().substring(0, 4));
	 return  versementDTO;
	 
}




}
