package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Imputations_Montant  extends Imputation{
private int Augmentation_capi;
private int Montant_excedant;
private int réduction_impot;
private int Reliquat_IS;
private int Reliquat_retenue_source;
}
