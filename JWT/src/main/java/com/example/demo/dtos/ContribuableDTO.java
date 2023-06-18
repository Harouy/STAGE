package com.example.demo.dtos;

import lombok.Data;

@Data
public class ContribuableDTO {
	private Long ID_Contribuable;
	private String Activité;
	private String Adresse;
	private int ATP;
	private String Compte_Bancaire;
	private String Email_Respo;
	private int ICE;
	private int ID_Fiscal;
	private String nom_respo;
	private String Raison_Sociale;
	private int tel_respo;
	private String Ville;
}
