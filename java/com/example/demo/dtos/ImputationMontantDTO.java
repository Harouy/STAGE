package com.example.demo.dtos;

import lombok.Data;

@Data
public class ImputationMontantDTO extends ImputationDTO {
	private int Augmentation_capi;
	private int Montant_excedant;
	private int réduction_impot;
	private int Reliquat_IS;
	private int Reliquat_retenue_source;
	
}
