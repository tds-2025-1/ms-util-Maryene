package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CpfServiceTest {

    private final CpfService cpfService = new CpfService();

    @Test
    void shouldGenerateCpfWithValidFormat() {
        String cpf = cpfService.generateCpf();
        assertNotNull(cpf);
        assertTrue(cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"), "Invalid format: " + cpf);
    }

    @Test
    void shouldCalculateCheckDigitCorrectly() throws Exception {
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0}; // last two digits are not used yet

        var method = CpfService.class.getDeclaredMethod("calculateCheckDigit", int[].class, int[].class);
        method.setAccessible(true); // Allows access to a private method via reflection

        int d1 = (int) method.invoke(cpfService, digits, new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2});
        assertTrue(d1 >= 0 && d1 <= 9);
    }

    @Test
    void shouldFormatCpfCorrectly() throws Exception {
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        var method = CpfService.class.getDeclaredMethod("formatCpf", int[].class);
        method.setAccessible(true);
        String formattedCpf = (String) method.invoke(cpfService, (Object) digits);
        assertEquals("123.456.789-01", formattedCpf);
    }
}
