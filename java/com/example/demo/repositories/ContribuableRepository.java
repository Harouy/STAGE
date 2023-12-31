package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contribuable;
import com.example.demo.entities.Versement;

@Repository
public interface ContribuableRepository extends JpaRepository<Contribuable,Long>{
 
	Contribuable findByID(Long ID);

}
