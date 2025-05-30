package br.edu.ifrs.riogrande.tads.tds.util.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PingServiceTest {
    // Teste Unitário (Unit Test: testar um módulo (classe))
    PingService pingService;
    
    // instanciar o PingService antes de cada teste
    @BeforeEach 
    void setup() {
        pingService = new PingService();
    }

    // TDD Test-Driven Development (Assertions.assertAlgo)
    // BDD Behavior-Driven Development (given(contexto).when(tal coisa).then(tal resultado))

    @Test
    @DisplayName("Testa se invocar o método ping retorna pong")
    void teste_ping_deve_retornar_pong() {
        // Assertiva
        assertEquals("pong", pingService.ping());
    }

}
