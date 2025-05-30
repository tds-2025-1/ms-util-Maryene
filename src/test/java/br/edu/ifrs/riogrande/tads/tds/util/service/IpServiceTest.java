package br.edu.ifrs.riogrande.tads.tds.util.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IpServiceTest {

    @Test
    void gera5IpsUnicosComIpValido() {
        IpService service = new IpService();
        String resultado = service.generateUniqueIps("192.168.1.1");

        String[] ips = resultado.split("\n");
        assertEquals(5, ips.length);
    }

    @Test
    void rejeitaIpInvalido() {
        IpService service = new IpService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.generateUniqueIps("192.168.1");
        });

        assertEquals("Formato de IP inválido. Use como exemplo: 192.168.1.1",
                exception.getMessage());
    }
}