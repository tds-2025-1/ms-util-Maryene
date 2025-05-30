package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.service.CpfService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CpfController {

    private final CpfService cpfService;

    public CpfController(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @Deprecated(since = "2025-05-07", forRemoval = false)
    @GetMapping(value = "/cpf", produces = MediaType.TEXT_PLAIN_VALUE)
    public String cpf() {
        return this.cpfService.generateCpf();
    }

    @GetMapping(value = "/api/v1/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<String> cpfV1() {
        return new ApiResponse<String>(this.cpfService.generateCpf());
    }

}
