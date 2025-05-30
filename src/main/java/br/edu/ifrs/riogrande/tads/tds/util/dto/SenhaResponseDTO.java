package br.edu.ifrs.riogrande.tads.tds.util.dto;

import java.time.LocalDateTime;

public class SenhaResponseDTO {

    private final int version = 1;
    private final String timestamp = LocalDateTime.now().toString();
    private final String result;

    public SenhaResponseDTO(String result) {
        this.result = result;
    }

    public int getVersion() {
        return version;
    }

    public String getResult() {
        return result;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
