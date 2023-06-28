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
public class Imputations_Listes extends Imputation {
private double Montant_total;
@OneToMany(mappedBy ="imputationslistes")
private List<Mo_ISPPRF> montantsISPPRF;
@OneToMany(mappedBy ="imputationslistes")
private List<Montretenuesource> montants;


}
