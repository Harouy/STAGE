package com.example.demo.dtos;



import java.sql.Date;

import com.example.demo.entities.Obligation_fiscale;

import lombok.Data;

@Data
public class VersementDTO {
	private Long ID;
	private String obligation_fiscale;
	private Date date_modification;
	private String exfiscal;
	
	private String modificateur;
	private String etat ;

}
