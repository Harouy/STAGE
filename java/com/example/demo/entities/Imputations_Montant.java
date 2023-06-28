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
private double Augmentation_capi;
private double Montant_excedant;
private double réduction_impot;
private double Reliquat_IS;
private double Reliquat_retenue_source;
}
