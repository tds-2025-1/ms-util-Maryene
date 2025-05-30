package br.edu.ifrs.riogrande.tads.tds.util.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDayResponse {
    private LocalDate resultDate;
}