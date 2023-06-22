package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ContribuableService;
import com.example.demo.dtos.ContribuableDTO;
import com.example.demo.entities.Contribuable;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.mappers.contribuableMapper;
import com.example.demo.security.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contribuable")
@Slf4j
@CrossOrigin("*")
public class ContribuableController {
	  private final ContribuableService contribuableservice;
	    private final JwtService jwtService;
	    private final contribuableMapper ContribuableMapper;

	    @GetMapping("/utilisateur")
	    public ContribuableDTO getContribuable(  HttpServletRequest request) throws PersonneNotFoundException
	    {
	        String authHeader = request.getHeader("Authorization");
	        String jwt = authHeader.substring(7);
	        Long idutilisateur = jwtService.extractIdPersonne(jwt);
	    	
	        return ContribuableMapper.fromContribuable( contribuableservice.getContribuableBYpersonne(idutilisateur));
	    }
}
