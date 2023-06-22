package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Contribuable;
import com.example.demo.entities.Utilisateur;
import com.example.demo.entities.Versement;


public interface VersementReposiotry extends JpaRepository<Versement,Long> {
	List<Versement> findByContribuable(Contribuable contribuable);
}
