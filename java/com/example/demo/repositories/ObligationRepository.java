package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Obligation_fiscale;

@Repository
public interface ObligationRepository extends JpaRepository<Obligation_fiscale,Long>{
Obligation_fiscale findByType(String Type);
}
