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
public class Etat_paiement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String etat;
@OneToMany(mappedBy="etat_paiement")
private List<Paiement> paiements;


}
