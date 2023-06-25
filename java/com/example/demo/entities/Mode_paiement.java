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
public class Mode_paiement {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
private String mode;
@OneToMany(mappedBy="mode_paiement")
private List<Paiement> paiements;
}
