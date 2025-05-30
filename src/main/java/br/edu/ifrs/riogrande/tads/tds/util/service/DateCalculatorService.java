package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class DateCalculatorService {

    public long calculateWeeksBetween(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        return days / 7;
    }
}

