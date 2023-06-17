package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Montretenuesource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	private int ICE;
	private int Identi_fiscal;
	private int montant_rémunérations;
	private int Montant_retenu;
	private String Raison_sociale;
	private Date date_prel;
	@ManyToOne
	private Imputations_Listes imputationslistes;

}
