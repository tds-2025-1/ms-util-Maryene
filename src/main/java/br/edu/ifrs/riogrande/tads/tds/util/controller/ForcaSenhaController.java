package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ForcaSenhaResponseDTOV1;
import br.edu.ifrs.riogrande.tads.tds.util.service.SenhaService;

@RestController
public class ForcaSenhaController {

    private final SenhaService senhaService;

    public ForcaSenhaController(SenhaService senhaService) {
        this.senhaService = senhaService;
    }

    @Deprecated(since = "2025-05-07", forRemoval = false)
    @GetMapping(value = "/forca-senha/{senha}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String forcaSenha(@PathVariable String senha) {
        return senhaService.forcaSenha(senha);
    }

    @GetMapping(value = "api/v1/forca-senha/{senha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ForcaSenhaResponseDTOV1> forcaSenhaV1(@PathVariable String senha) {
        String resp = senhaService.forcaSenha(senha);
        return new ApiResponse<ForcaSenhaResponseDTOV1>(ForcaSenhaResponseDTOV1.of(resp));
    }
}