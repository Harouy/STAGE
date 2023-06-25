package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Imputation {
	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
@ManyToOne
private Versement versement;

}
