package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeElapsedCalculatorService {

   
    public String calculateTimeElapsed(LocalTime startTime, LocalTime endTime) {
        Duration duration;
        
        if (endTime.isBefore(startTime)) {
            duration = Duration.between(startTime, LocalTime.MAX)
                      .plusNanos(Duration.between(LocalTime.MIN, endTime).toNanos())
                      .plusNanos(1); // Adiciona 1 nano para compensar o nanosegundo entre 23:59:59.999999999 e 00:00:00
        } else {
            duration = Duration.between(startTime, endTime);
        }
        
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}