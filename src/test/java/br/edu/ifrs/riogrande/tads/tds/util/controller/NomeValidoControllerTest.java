package br.edu.ifrs.riogrande.tads.tds.util.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.NomeValidoDTOV1;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.PingResponseDTOV3;
import br.edu.ifrs.riogrande.tads.tds.util.service.nomeValidoService;

@SpringBootTest
@AutoConfigureMockMvc
public class NomeValidoControllerTest {

    @MockitoBean
    nomeValidoService nomeValidoService;
    
    @Autowired
    ObjectMapper objectMapper;
    
    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Testa um nome valido retorna 200, texto nome em texto plano")
    void testaUmNomeValidoRetorna200TextoNomeEmTextoPlano() throws Exception {
        Mockito.when(nomeValidoService.nomeValido()).thenReturn("joao silva");

        mvc.perform(get("/nomeValido").accept(MediaType.TEXT_PLAIN_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("joao silva"))
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andReturn();
    }

    @Test
    @DisplayName("Testa nome valido v3 Retorna Objeto")
    void testaNomeValidoV3RetornaObjeto() throws Exception {
        Mockito.when(nomeValidoService.nomeValido()).thenReturn("joao silva");

        var result = mvc.perform(
                get("/api/v1/nomeValido")
                .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        System.out.println(resp);
        NomeValidoDTOV1 obj = objectMapper.readValue(resp, NomeValidoDTOV1.class);
        assertNotNull(obj);
        assertEquals(1, obj.getVersion());
        // assertEquals(1, map.get("version"));
        // assertEquals("pong pong", map.get("result"));
    }
}
