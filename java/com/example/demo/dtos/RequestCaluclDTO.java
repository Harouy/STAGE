package com.example.demo.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RequestCaluclDTO {
	private double montantref;
	private double montantTotalImpu;
   private LocalDate dateexegibilité;
	
}
