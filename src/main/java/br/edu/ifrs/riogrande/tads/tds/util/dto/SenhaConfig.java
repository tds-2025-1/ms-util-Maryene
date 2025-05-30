package br.edu.ifrs.riogrande.tads.tds.util.dto;

public class SenhaConfig {
    private int tamanho = 12;
    private boolean maiusculas = true;
    private boolean minusculas = true;
    private boolean numeros = true;
    private boolean simbolos = true;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isMaiusculas() {
        return maiusculas;
    }

    public void setMaiusculas(boolean maiusculas) {
        this.maiusculas = maiusculas;
    }

    public boolean isMinusculas() {
        return minusculas;
    }

    public void setMinusculas(boolean minusculas) {
        this.minusculas = minusculas;
    }

    public boolean isNumeros() {
        return numeros;
    }

    public void setNumeros(boolean numeros) {
        this.numeros = numeros;
    }

    public boolean isSimbolos() {
        return simbolos;
    }

    public void setSimbolos(boolean simbolos) {
        this.simbolos = simbolos;
    }
}
