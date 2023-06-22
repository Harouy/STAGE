package com.example.demo.entities;



import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Versement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long ID;
private Date Date_Création;
private Date date_dépo;
private Date date_modification;
private Date date_exigibilité;
private Date exercice_fical_du;
private Date exercice_fiscal_au;
private int Montant_principal;
private int Montant_principal_du;
private int Montant_total_impu;
private int Montant_pénalité_retard;
private int Montant_principal_payé;
private int version;
private long idmodificateur;
@ManyToOne
private Contribuable contribuable;
@ManyToOne
private Etat_versement etat_versement;
@OneToOne
private Obligation_fiscale obligation_fiscale;
@OneToMany(mappedBy="versement")
private List<Imputation> imputations;
@OneToOne(mappedBy="versement")
private Paiement paiement;


}
