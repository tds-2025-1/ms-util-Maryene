package br.edu.ifrs.riogrande.tads.tds.util.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ForcaSenhaResponseDTOV1;
import br.edu.ifrs.riogrande.tads.tds.util.service.SenhaService;

@SpringBootTest
@AutoConfigureMockMvc
public class ForcaSenhaControllerTest {

    @MockitoBean
    SenhaService senhaService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Testa forcaSenha retorna 200, texto com a forca e a nota em texto plano")
    void testaForcaSenhaDeveRetornar200Texto() throws Exception {
        Mockito.when(senhaService.forcaSenha("aaa")).thenReturn("MUITO_FRACA : Nota 0");

        mvc.perform(get("/forca-senha/aaa"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("MUITO_FRACA : Nota 0"))
                .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    @DisplayName("Testa forcaSenha retorna 200 e o objeto que contém a forca : nota e a versão da API")
    void testaForcaSenhaRetorna200Objeto() throws Exception {
        Mockito.when(senhaService.forcaSenha("aaa")).thenReturn("MUITO_FRACA : Nota 0");

        var result = mvc.perform(
                get("/api/v1/forca-senha/aaa")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        ApiResponse<ForcaSenhaResponseDTOV1> obj = objectMapper.readValue(resp, ApiResponse.class);
        assertNotNull(obj);
        // assertEquals(1, obj.getData().getVersion());
        // assertEquals("MUITO_FRACA : Nota 0", obj.getData().getResult());
    }
}