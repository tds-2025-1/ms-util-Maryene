package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;


/**
 * @author Josué Fernandes
 * Referência: https://www.geradorcpf.com/algoritmo_do_cpf.htm
 * Validação: https://www.4devs.com.br/validador_cpf         
 */

@Service
public class CpfService {

    private static final Logger logger = LoggerFactory.getLogger(CpfService.class);
    private static final int[] SECOND_DIGIT_WEIGHTS = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
    private static final int[] FIRST_DIGIT_WEIGHTS = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
    private static final int CPF_LENGTH = 11;
    
    private int generateRandomDigit() {
        return ThreadLocalRandom.current().nextInt(10);
    }

    private int[] generateDigits() {
        int[] digits = new int[CPF_LENGTH];
        for (int i = 0; i < 9; i++) {
            digits[i] = this.generateRandomDigit();
        }

        return digits;
    }

    private int calculateCheckDigit(int[] digits, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += digits[i] * weights[i];
        }

        int remainder = (int) (sum % CPF_LENGTH);
        int checkDigit = (remainder < 2) ? 0 : CPF_LENGTH - remainder;

        logger.info("Sum: " + sum);
        logger.info("Digit: " + checkDigit);

        return checkDigit;
    }

    String formatCpf(int[] digits) {
        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d",
                digits[0], digits[1], digits[2],
                digits[3], digits[4], digits[5],
                digits[6], digits[7], digits[8],
                digits[9], digits[10]);
    }

    public String generateCpf() {
        int[] cpfDigits = generateDigits();

        cpfDigits[9] = this.calculateCheckDigit(cpfDigits, FIRST_DIGIT_WEIGHTS);
        cpfDigits[10] = this.calculateCheckDigit(cpfDigits, SECOND_DIGIT_WEIGHTS);

        return this.formatCpf(cpfDigits);
    }
}
