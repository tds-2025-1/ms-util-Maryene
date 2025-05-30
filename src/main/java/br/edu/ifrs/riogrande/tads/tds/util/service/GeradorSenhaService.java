package br.edu.ifrs.riogrande.tads.tds.util.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.tds.util.dto.SenhaConfig;

@Service
public class GeradorSenhaService {

    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$%&*()-_=+[]{}<>?/";
    
    public String gerarSenha(SenhaConfig senhaConfig) {
        StringBuilder caracteres = new StringBuilder();
        
        int tamanho = senhaConfig.getTamanho();
        boolean maiusculas = senhaConfig.isMaiusculas();
        boolean minusculas = senhaConfig.isMinusculas();
        boolean numeros = senhaConfig.isNumeros();
        boolean simbolos = senhaConfig.isSimbolos();

        if (maiusculas) caracteres.append(LETRAS_MAIUSCULAS);
        if (minusculas) caracteres.append(LETRAS_MINUSCULAS);
        if (numeros) caracteres.append(NUMEROS);
        if (simbolos) caracteres.append(SIMBOLOS);

        if (caracteres.length() == 0) {
            return "Erro: selecione ao menos um tipo de caractere.";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }
}