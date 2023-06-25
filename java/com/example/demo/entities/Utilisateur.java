package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String login;
    @ManyToOne
    private Contribuable contribuable;
    @ManyToMany
    @JoinTable(name="Type_utilisateur" ,joinColumns=@JoinColumn(name="Id_Utilisateur"),inverseJoinColumns=@JoinColumn(name="Id_Type_profil"))
    private List<Type_profil> type_profils;

   
}
