package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mo_ISPPRF {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id_ISPPRF;
private int Identi_fiscal;
private Date date_prel;
private double Montants_produits;
private double Montant_retenue;
private String Raison_Sociale;
private int rel_prel;
@ManyToOne
private Imputations_Listes imputationslistes;

}
