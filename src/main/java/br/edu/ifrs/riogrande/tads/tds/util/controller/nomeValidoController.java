package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.NomeValidoDTOV1;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.PingResponseDTOV3;
import br.edu.ifrs.riogrande.tads.tds.util.service.nomeValidoService;

@RestController
public class nomeValidoController {

    private final nomeValidoService nomeValidoService;

    public nomeValidoController(nomeValidoService nomeValidoService) {
        this.nomeValidoService = nomeValidoService;
    }
    
    @GetMapping(
        value = "/nomeValido", 
        produces = MediaType.TEXT_PLAIN_VALUE)

    public String nomeValido() {
        return nomeValidoService.nomeValido();
    }

    @GetMapping(
        value = "/api/v1/nomeValido", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<NomeValidoDTOV1> nomeValidov1() {
        // {"versao": 1, "result": "pong", "dateTime": ...}
        String resp = nomeValidoService.nomeValido();

        return new ApiResponse<NomeValidoDTOV1>(NomeValidoDTOV1.of(resp));
    } 
}