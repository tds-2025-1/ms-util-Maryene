package br.edu.ifrs.riogrande.tads.tds.util.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BusinessDayRequest {
    private LocalDate startDate;
    private int businessDays;
}