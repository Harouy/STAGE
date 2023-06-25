package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etat_versement {
@Id
private long Id;
private String Etat;
@OneToMany(mappedBy="etat_versement")
private List<Versement> versements;

}
