package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Type_profil {
@Id
private long Id_Type_profil;
private String Type;
@ManyToMany(mappedBy="type_profils")
private List<Utilisateur> utilisateurs;


}
