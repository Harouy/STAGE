package com.example.demo.entities;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paiement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long Id;
private Date date_paiement;
private double Montant_total;
private int ticket;
@OneToOne
private Versement versement;
@ManyToOne
private Etat_paiement etat_paiement;
@ManyToOne
private Mode_paiement mode_paiement;
}
