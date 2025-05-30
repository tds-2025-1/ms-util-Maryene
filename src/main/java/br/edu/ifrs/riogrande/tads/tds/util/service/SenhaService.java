package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;

@Service
public class SenhaService {

    private String numeros = "0123456789";
    private String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String caracterEspecial = "!#$%*+.-?@_";

    public enum Forca {
        MUITO_FORTE,
        FORTE,
        INTERMEDIÁRIA,
        FRACA,
        MUITO_FRACA,
        INVÁLIDO
    }

    Forca nivelSenha(int forca) {
        if (forca >= 0 && forca <= 10) {
            if (forca < 3) {
                return Forca.MUITO_FRACA;
            } else if (forca < 5) {
                return Forca.FRACA;
            } else if (forca < 7) {
                return Forca.INTERMEDIÁRIA;
            } else if (forca < 9) {
                return Forca.FORTE;
            } else if (forca <= 10) {
                return Forca.MUITO_FORTE;
            }
        }
        return Forca.INVÁLIDO;
    }

    int calculoForcaSenha(String senha) {
        int forcaSenha = 0;
        if (senha.length() >= 4 && senha.length() <= 7) {
            forcaSenha++;
        } else if (senha.length() > 7) {
            forcaSenha += 4;
        }

        int maiuscula = 0;
        int numero = 0;
        int charEspecial = 0;

        for (int i = 0; i < senha.length(); i++) {
            if (this.letrasMaiusculas.contains(String.valueOf(senha.charAt(i))) && maiuscula < 1) {
                forcaSenha++;
                maiuscula = 1;
            }
            if (this.numeros.contains(String.valueOf(senha.charAt(i))) && numero < 2) {
                forcaSenha += 2;
                numero = 2;
            }
            if (this.caracterEspecial.contains(String.valueOf(senha.charAt(i))) && charEspecial < 3) {
                forcaSenha += 3;
                charEspecial = 3;
            }
            if (maiuscula == 1 && numero == 2 && charEspecial == 3) {
                break;
            }
        }
        return forcaSenha;
    }

    public String forcaSenha(String senha) {
        int forcaCalculada = calculoForcaSenha(senha);
        Forca textForca = this.nivelSenha(forcaCalculada);

        return textForca + " : Nota " + forcaCalculada;
    }
}