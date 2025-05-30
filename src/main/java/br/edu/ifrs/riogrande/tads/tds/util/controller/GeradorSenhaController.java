package br.edu.ifrs.riogrande.tads.tds.util.controller;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.dto.SenhaConfig;
import br.edu.ifrs.riogrande.tads.tds.util.dto.SenhaResponseDTO;
import br.edu.ifrs.riogrande.tads.tds.util.service.GeradorSenhaService;

@RestController
@RequestMapping("/api")
public class GeradorSenhaController {

    private final GeradorSenhaService geradorSenhaService;

    public GeradorSenhaController(GeradorSenhaService geradorSenhaService) {
        this.geradorSenhaService = geradorSenhaService;
    }

    @PostMapping("/gerar-senha")
    public String nomeValido(@RequestBody SenhaConfig dto) {
        return geradorSenhaService.gerarSenha(dto);
    }

    @PostMapping(
    value = "/v1/gerar-senha",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SenhaResponseDTO> gerarSenha(@RequestBody SenhaConfig dto) {
        String senha = geradorSenhaService.gerarSenha(dto);
        SenhaResponseDTO response = new SenhaResponseDTO(senha);
        return new ApiResponse<>(response);
    }
}