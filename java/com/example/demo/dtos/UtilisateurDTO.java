package com.example.demo.dtos;


import lombok.Data;

@Data
public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String login;
    private Long id_contribuable;
}