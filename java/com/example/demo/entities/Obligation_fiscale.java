package com.example.demo.entities;

import java.util.Date;
import java.util.List;

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
@OneToMany(mappedBy="obligation_fiscale")
private List<Versement> versement;
	
}
