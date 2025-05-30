package br.edu.ifrs.riogrande.tads.tds.util.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

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

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.PingResponseDTOV2;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.PingResponseDTOV3;
import br.edu.ifrs.riogrande.tads.tds.util.service.PingService;

@SpringBootTest
@AutoConfigureMockMvc
public class PingControllerTest {

    @MockitoBean
    PingService pingService;

    @Autowired
    ObjectMapper objectMapper;
    
    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Testa Ping retorna 200, texto pong em texto plano")
    void testaPingDeveRetornar200TextComTextoPong() throws Exception {
        Mockito.when(pingService.ping()).thenReturn("pong pong");

        mvc.perform(get("/ping").accept(MediaType.TEXT_PLAIN_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("pong pong"))
            .andExpect(content().contentType("text/plain;charset=UTF-8"))
            .andReturn();
    }

    
    @Test
    @DisplayName("Testa Ping v1 Retorna Objeto")
    void testaPingV1RetornaObjeto() throws Exception {
        Mockito.when(pingService.ping()).thenReturn("pong pong");

        var result = mvc.perform(get("/ping?version=1").accept(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();
    
        String resp = result.getResponse().getContentAsString();
        System.out.println(resp);
        Map<String, Object> map = objectMapper.readValue(resp, Map.class);
        System.out.println(map);
        assertNotNull(map);
        //assertEquals(1, map.get("version"));
        //assertEquals("pong pong", map.get("result"));
    }

    @Test
    @DisplayName("Testa Ping v2 Retorna Objeto")
    void testaPingV2RetornaObjeto() throws Exception {
        Mockito.when(pingService.ping()).thenReturn("pong pong");

        var result = mvc.perform(
                    get("/ping")
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .header("X-TADS-Version", "2")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        System.out.println(resp);
        PingResponseDTOV2 obj = objectMapper.readValue(resp, PingResponseDTOV2.class);
        assertNotNull(obj);
        assertEquals(2, obj.getVersion());
        // assertEquals(1, map.get("version"));
        // assertEquals("pong pong", map.get("result"));
    }


    @Test
    @DisplayName("Testa Ping v3 Retorna Objeto")
    void testaPingV3RetornaObjeto() throws Exception {
        Mockito.when(pingService.ping()).thenReturn("pong pong");

        var result = mvc.perform(
                get("/ping")
                        .accept("application/vnd.tads-ms-util.v3+json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/vnd.tads-ms-util.v3+json"))
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        System.out.println(resp);
        PingResponseDTOV3 obj = objectMapper.readValue(resp, PingResponseDTOV3.class);
        assertNotNull(obj);
        assertEquals(3, obj.getVersion());
        // assertEquals(1, map.get("version"));
        // assertEquals("pong pong", map.get("result"));
    }
}
