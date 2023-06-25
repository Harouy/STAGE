package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ContribuableService;
import com.example.demo.Services.VersementService;
import com.example.demo.dtos.FormulaireRequest;
import com.example.demo.dtos.VersementDTO;
import com.example.demo.entities.Versement;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.mappers.contribuableMapper;
import com.example.demo.security.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/versement")
@Slf4j
@CrossOrigin("*")
public class VersementController {
	private final JwtService jwtService;
	private final VersementService versementservice;
	@GetMapping("/personnes")
	public List<VersementDTO> getVersements( HttpServletRequest request) throws PersonneNotFoundException{

        String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        Long idcontribuable = jwtService.extractIdContribuable(jwt);
        return versementservice.getversements(idcontribuable);
	}

	  @PostMapping("/dateex")
	public ResponseEntity<LocalDateTime> getdateexegibilite(HttpServletRequest request,@RequestBody FormulaireRequest formulaire) {
		  
		LocalDateTime date=versementservice.getDateexegibilité(formulaire);
		return ResponseEntity.ok(date);
	}

}
