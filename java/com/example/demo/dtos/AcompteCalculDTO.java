package com.example.demo.dtos;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import lombok.Data;

@Data
public class AcompteCalculDTO {
private double montantprincipal;
private double montantduprincipal;
private double montantmajorations;
private double montantpenalite;
private double montanttotal;

}
