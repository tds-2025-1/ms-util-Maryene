package br.edu.ifrs.riogrande.tads.tds.util.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.edu.ifrs.riogrande.tads.tds.util.service.IpService;

@WebMvcTest(IpController.class)
public class IpControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private IpService ipService;

        @Test
        void versaoOriginalComIpValido() throws Exception {
                String mockResponse = "192.168.1.1\n192.168.1.2\n192.168.1.3\n192.168.1.4\n192.168.1.5";

                when(ipService.generateUniqueIps("192.168.1.1"))
                                .thenReturn(mockResponse);

                mockMvc.perform(get("/ips/192.168.1.1"))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"))
                                .andExpect(content().string(mockResponse));
        }

        @Test
        void versaoV1ComIpValido() throws Exception {
                String mockResponse = "192.168.1.1\n192.168.1.2\n192.168.1.3\n192.168.1.4\n192.168.1.5";

                when(ipService.generateUniqueIps("192.168.1.1"))
                                .thenReturn(mockResponse);

                mockMvc.perform(get("/api/v1/ips/192.168.1.1"))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.data.version", is(1)))
                                .andExpect(jsonPath("$.data.ips", hasSize(5)))
                                .andExpect(jsonPath("$.data.ips[0]", is("192.168.1.1")))
                                .andExpect(jsonPath("$.data.ips[4]", is("192.168.1.5")));
        }

        @Test
        void versaoV1ComIpInvalido() throws Exception {
                when(ipService.generateUniqueIps("192.168.1"))
                                .thenThrow(new IllegalArgumentException("Formato de IP inválido"));

                mockMvc.perform(get("/api/v1/ips/192.168.1"))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.data.version", is(1)))
                                .andExpect(jsonPath("$.data.ips[0]", startsWith("Erro: ")));
        }
}