package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

import java.time.LocalDateTime;

public class PingResponseDTOV3 {
    // método fábrica: factory method
    public static PingResponseDTOV3 of(String result) {
        return new PingResponseDTOV3(result);
    }

    private final int version = 3;
    private final String dateTime = LocalDateTime.now().toString();
    private final String result;

    private PingResponseDTOV3(String result) {
        this.result = result;
    }

    public int getVersion() {
        return version;
    }

    public String getResult() {
        return result;
    }

    public String getDateTime() {
        return dateTime;
    }
}
