package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
}
