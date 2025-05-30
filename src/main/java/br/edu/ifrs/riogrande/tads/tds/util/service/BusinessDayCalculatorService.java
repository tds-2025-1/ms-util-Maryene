package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class BusinessDayCalculatorService {
    
    /**
     * Calcula a data após adicionar uma quantidade específica de dias úteis.
     * Considera apenas dias de semana (segunda a sexta) como dias úteis.
     * 
     * @param startDate Data inicial
     * @param businessDays Número de dias úteis a adicionar
     * @return Data resultante após adicionar os dias úteis
     */
    public LocalDate calculateDateAfterBusinessDays(LocalDate startDate, int businessDays) {
        LocalDate result = startDate;
        int addedDays = 0;
        
        while (addedDays < businessDays) {
            result = result.plusDays(1);
            if (!isWeekend(result)) {
                addedDays++;
            }
        }
        
        return result;
    }
    
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}