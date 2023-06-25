package com.example.demo.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class AcompteDTO {
private Long ID;
private Date exercice_fical_du;
private Date exercice_fiscal_au;
private int Montant_principal;

}
