package br.edu.ifrs.riogrande.tads.tds.util.controller;

import br.edu.ifrs.riogrande.tads.tds.util.service.CpfService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CpfController.class)
class CpfControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CpfService cpfService;

    @Test
    void shouldReturnMockedCpfWithStatus200() throws Exception {
        String mockedCpf = "191.336.000-82";
        when(cpfService.generateCpf()).thenReturn(mockedCpf);

        mockMvc.perform(get("/cpf"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(mockedCpf));
    }

    @Test
    void shouldReturnMockedCpfInJsonFormatWithStatus200() throws Exception {
        String mockedCpf = "191.336.000-82";
        when(cpfService.generateCpf()).thenReturn(mockedCpf);

        mockMvc.perform(get("/api/v1/cpf"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.data").value(mockedCpf));
    }
}
