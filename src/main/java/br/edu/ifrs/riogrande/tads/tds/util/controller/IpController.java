package br.edu.ifrs.riogrande.tads.tds.util.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.IpResponseDTOV1;
import br.edu.ifrs.riogrande.tads.tds.util.service.IpService;
import java.util.List;
import java.util.Arrays;

@RestController
public class IpController {

    private final IpService ipService;

    public IpController(IpService ipService) {
        this.ipService = ipService;
    }

    @Deprecated(since = "2025-05-10", forRemoval = false)
    @GetMapping(value = "/ips/{baseIp}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateIps(@PathVariable String baseIp) {
        try {
            return ipService.generateUniqueIps(baseIp);
        } catch (IllegalArgumentException e) {
            return "Erro: " + e.getMessage();
        }
    }

    @GetMapping(value = "/api/v1/ips/{baseIp}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<IpResponseDTOV1> generateIpsV1(@PathVariable String baseIp) {
        try {
            String ips = ipService.generateUniqueIps(baseIp);
            return new ApiResponse<IpResponseDTOV1>(IpResponseDTOV1.of(Arrays.asList(ips.split("\n"))));
        } catch (IllegalArgumentException e) {
            return new ApiResponse<IpResponseDTOV1>(IpResponseDTOV1.of(List.of("Erro: " + e.getMessage())));
        }
    }
}
