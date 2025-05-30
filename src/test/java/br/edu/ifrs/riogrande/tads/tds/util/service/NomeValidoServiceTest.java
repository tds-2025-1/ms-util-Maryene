package br.edu.ifrs.riogrande.tads.tds.util.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NomeValidoServiceTest {
    
    nomeValidoService nomeValidoService;
    
    // instanciar o PingService antes de cada teste
    @BeforeEach 
    void setup() {
        nomeValidoService = new nomeValidoService();
    }

    // TDD Test-Driven Development (Assertions.assertAlgo)
    // BDD Behavior-Driven Development (given(contexto).when(tal coisa).then(tal resultado))

    @Test
    @DisplayName("Testa se invocar o método ping retorna um nome valido")
    void teste_ping_deve_retornar_pong() {
        String nome = nomeValidoService.nomeValido();
        String[] partes = nome.split(" ");
        assertEquals(2,partes.length);
        assertNotNull(partes[0]);
        assertNotNull(partes[1]);
        assertTrue(Arrays.asList(nomeValidoService.nomes).contains(partes[0]));
        assertTrue(Arrays.asList(nomeValidoService.sobrenomes).contains(partes[1]));
    }
}
