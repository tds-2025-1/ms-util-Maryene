package br.edu.ifrs.riogrande.tads.tds.util.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SenhaServiceTest {
    SenhaService senhaService;

    @BeforeEach
    void setup() {
        senhaService = new SenhaService();
    }

    // TESTES para validar o método nivelSenha

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número negativo retorna INVÁLIDO")
    void teste_nivelSenha_int_negativo_deve_retornar_invalido() {
        assertEquals("INVÁLIDO", senhaService.nivelSenha(-5).name());
    }

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número maior que 10 retorna INVÁLIDO")
    void teste_nivelSenha_int_maior_dez_deve_retornar_invalido() {
        assertEquals("INVÁLIDO", senhaService.nivelSenha(31).name());
    }

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número maior ou igual a 9 e menor ou igual a 10 retorna MUITO_FORTE")
    void teste_nivelSenha_int_maiorigual_nove_e_menorigual_dez_deve_retornar_muito_forte() {
        assertEquals("MUITO_FORTE", senhaService.nivelSenha(9).name());
    }

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número maior ou igual a 7 e menor que 9 retorna FORTE")
    void teste_nivelSenha_int_maiorigual_sete_e_menor_nove_deve_retornar_forte() {
        assertEquals("FORTE", senhaService.nivelSenha(7).name());
    }

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número maior ou igual a 5 e menor que 7 retorna INTERMEDIÁRIA")
    void teste_nivelSenha_int_maiorigual_cinco_e_menor_sete_deve_retornar_intermediaria() {
        assertEquals("INTERMEDIÁRIA", senhaService.nivelSenha(5).name());
    }

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número maior ou igual a 3 e menor que 5 retorna FRACA")
    void teste_nivelSenha_int_maiorigual_tres_e_menor_cinco_deve_retornar_fraca() {
        assertEquals("FRACA", senhaService.nivelSenha(4).name());
    }

    @Test
    @DisplayName("Testa se invocar o método nivelSenha pasando um número maior ou igual a 0 e menor que 3 retorna MUITO_FRACA")
    void teste_nivelSenha_int_maiorigual_zero_e_menor_tres_deve_retornar_muito_fraca() {
        assertEquals("MUITO_FRACA", senhaService.nivelSenha(2).name());
    }

    // TESTES para validar o método calculoForcaSenha

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abc retorna 0")
    void teste_calculoForcaSenha_senha_abc_deve_retornar_zero() {
        assertEquals(0, senhaService.calculoForcaSenha("abc"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abcdef retorna 1")
    void teste_calculoForcaSenha_senha_abcdef_deve_retornar_um() {
        assertEquals(1, senhaService.calculoForcaSenha("abcdef"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abCd retorna 2")
    void teste_calculoForcaSenha_senha_abCd_deve_retornar_dois() {
        assertEquals(2, senhaService.calculoForcaSenha("abCd"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abcd123 retorna 3")
    void teste_calculoForcaSenha_senha_abcd123_deve_retornar_tres() {
        assertEquals(3, senhaService.calculoForcaSenha("abcd123"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abcdefghij retorna 4")
    void teste_calculoForcaSenha_senha_abcdefghij_deve_retornar_quatro() {
        assertEquals(4, senhaService.calculoForcaSenha("abcdefghij"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abcDefgHiJ retorna 5")
    void teste_calculoForcaSenha_senha_abcDefgHiJ_deve_retornar_cinco() {
        assertEquals(5, senhaService.calculoForcaSenha("abcDefgHiJ"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha 12548649 retorna 6")
    void teste_calculoForcaSenha_senha_12548649_deve_retornar_seis() {
        assertEquals(6, senhaService.calculoForcaSenha("12548649"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha Abc_ef3 retorna 7")
    void teste_calculoForcaSenha_senha_com_caracter_especial_deve_retornar_sete() {
        assertEquals(7, senhaService.calculoForcaSenha("Abc_ef3"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abcD*fgH+J retorna 8")
    void teste_calculoForcaSenha_senha_com_caracter_especial_deve_retornar_oito() {
        assertEquals(8, senhaService.calculoForcaSenha("abcD*fgH+J"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abc5efg8i2#k@ retorna 9")
    void teste_calculoForcaSenha_senha_com_caracter_especial_deve_retornar_nove() {
        assertEquals(9, senhaService.calculoForcaSenha("abc5efg8i2#k@"));
    }

    @Test
    @DisplayName("Testa se invocar o método calculoForcaSenha pasando a senha abcDefgHiJ12@589! retorna 10")
    void teste_calculoForcaSenha_senha_com_caracter_especial_deve_retornar_dez() {
        assertEquals(10, senhaService.calculoForcaSenha("abcDefgHiJ12@589!"));
    }
}