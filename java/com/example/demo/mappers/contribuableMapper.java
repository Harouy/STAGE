package com.example.demo.mappers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ContribuableDTO;
import com.example.demo.dtos.UtilisateurDTO;
import com.example.demo.entities.Contribuable;
import com.example.demo.entities.Utilisateur;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class contribuableMapper {
 public ContribuableDTO fromContribuable(Contribuable contribuable) {
	        ContribuableDTO contribuableDTO = new ContribuableDTO();
	        BeanUtils.copyProperties(contribuable,contribuableDTO);
	        return contribuableDTO;
	    }

	    public Contribuable fromContribuableDTO(ContribuableDTO contribuableDTO) {
	        Contribuable contribuable= new Contribuable();
	        BeanUtils.copyProperties(contribuableDTO,contribuable);
	      
	        return contribuable;
	    }

}
