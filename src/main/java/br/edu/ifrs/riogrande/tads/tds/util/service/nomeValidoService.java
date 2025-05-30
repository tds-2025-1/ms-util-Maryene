package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;

@Service
public class nomeValidoService {
    
    String[] nomes = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Juliana", "Lucas", "Mariana", "Nicolas", "Olivia", "Paulo", "Quiteria", "Rafael", "Sofia", "Thiago", "Ursula", "Vinicius", "Wesley", "Xuxa", "Yasmin", "Zoe"};
    String[] sobrenomes = {"Almeida", "Barbosa", "Cavalcante", "Dantas", "Elias", "Ferreira", "Gomes", "Henrique", "Igreja", "Jardim", "Klein", "Lima", "Melo", "Neto", "Oliveira", "Pereira", "Queiroz", "Ribeiro", "Silva", "Teixeira", "Uchoa", "Vasconcelos", "Xavier", "Yamamoto", "Zanetti"};

    public String nomeValido() {
        String nome = nomes[(int) (Math.random() * nomes.length)];
        String sobrenome = sobrenomes[(int) (Math.random() * sobrenomes.length)];
        return nome + " " + sobrenome;
    }
}