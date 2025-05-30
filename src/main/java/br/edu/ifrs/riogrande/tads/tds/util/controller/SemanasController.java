package br.edu.ifrs.riogrande.tads.tds.util.controller;
import br.edu.ifrs.riogrande.tads.tds.util.service.DateCalculatorService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/semanas")
public class SemanasController {

    private final DateCalculatorService dateCalculatorService;

    // Injeção de dependência via construtor (boa prática)
    public SemanasController(DateCalculatorService dateCalculatorService) {
        this.dateCalculatorService = dateCalculatorService;
    }

    @GetMapping
    public long calcularSemanas(
            @RequestParam String dataInicial,
            @RequestParam String dataFinal) {

        LocalDate inicio = LocalDate.parse(dataInicial);
        LocalDate fim = LocalDate.parse(dataFinal);

        return dateCalculatorService.calculateWeeksBetween(inicio, fim);
    }
}


