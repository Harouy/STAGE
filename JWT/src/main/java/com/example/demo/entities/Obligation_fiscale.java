package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Obligation_fiscale {
@Id
private Long Id;
private String type;
@OneToOne
private Versement versement;
	
}
