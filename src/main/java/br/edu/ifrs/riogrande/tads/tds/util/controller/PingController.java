package br.edu.ifrs.riogrande.tads.tds.util.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.ApiResponse;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.PingResponseDTOV2;
import br.edu.ifrs.riogrande.tads.tds.util.controller.dto.PingResponseDTOV3;
import br.edu.ifrs.riogrande.tads.tds.util.service.PingService;

@RestController
public class PingController {

    private final PingService pingService;

    public PingController(PingService pingService) {
        this.pingService = pingService;
    }

    // ping não versionado: LEGACY, VERSION 0
    // GET http://localhost:8080/ping
    // status: 200
    // header Content-Type: text/plain
    // body content: pong
    @Deprecated(since = "2025-04-30", forRemoval = false)
    @GetMapping(
        value = "/ping", 
        produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        String resp = pingService.ping();
        // "pong"
        return resp;
    }

    // versão via query param
    // GET http://localhost:8080/ping?versao=1
    @GetMapping(
        value = "/ping",
        params = "version=1",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Map<String, Object> pingV1() {
        // {"versao": 1, "result": "pong", "timestamp": ...}
        String resp = pingService.ping();

        return Map.of(
            "versao", 1,
            "timestamp", LocalDateTime.now().toString(),
            "result", resp
        );
    }

    @GetMapping(
        value = "/ping",
        headers = "X-TADS-version=2",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public PingResponseDTOV2 pingV2() {
        // {"versao": 1, "result": "pong", "timestamp": ..., "vendor": "TADS"}
        String resp = pingService.ping();

        return new PingResponseDTOV2(resp);
    }

    @GetMapping(
        value = "/ping", 
        produces = "application/vnd.tads-ms-util.v3+json")
    public PingResponseDTOV3 pingV3() {
        // {"versao": 1, "result": "pong", "dateTime": ...}
        String resp = pingService.ping();

        return PingResponseDTOV3.of(resp);
    }
   @GetMapping(
        value = "/api/v4/ping", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<PingResponseDTOV3> pingV4() {
        // {"versao": 1, "result": "pong", "dateTime": ...}
        String resp = pingService.ping();

        return new ApiResponse<PingResponseDTOV3>(PingResponseDTOV3.of(resp));
    } 

}
