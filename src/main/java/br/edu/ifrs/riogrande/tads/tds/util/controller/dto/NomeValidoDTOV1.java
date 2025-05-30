package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

import java.time.LocalDateTime;

public class NomeValidoDTOV1 {
     // método fábrica: factory method
    public static NomeValidoDTOV1 of(String result) {
        return new NomeValidoDTOV1(result);
    }

    private final int version = 1;
    private final String dateTime = LocalDateTime.now().toString();
    private final String result;

    private NomeValidoDTOV1(String result) {
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
