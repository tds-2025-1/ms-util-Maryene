package br.edu.ifrs.riogrande.tads.tds.util.dto;

import java.time.LocalTime;
import lombok.Data;

@Data
public class TimeElapsedRequest {
    private LocalTime startTime;
    private LocalTime endTime;
}