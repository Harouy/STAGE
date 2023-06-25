package com.example.demo.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FormulaireRequest {
private String type;
private LocalDateTime exercicedu;
}
