package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contribuable {
@Id
private Long ID;
private String Activité;
private String Adresse;
private int ATP;
private String Compte_Bancaire;
private String Email_Respo;
private int ICE;
private int ID_Fiscal;
private String nom_respo;
private String Raison_Sociale;
private int tel_respo;
private String Ville;
@OneToMany(mappedBy="contribuable")
private List<Utilisateur> utilisateurs;
@OneToMany(mappedBy="contribuable")
private List<Versement> versements;
}
