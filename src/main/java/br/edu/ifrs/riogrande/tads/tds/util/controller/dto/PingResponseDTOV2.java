package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

import java.time.LocalDateTime;

public class PingResponseDTOV2 {

    private final int version = 2;
    private final String timestamp = LocalDateTime.now().toString();
    private final String vendor = "TADS";
    private final String result;

    public PingResponseDTOV2(String result) {
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

    public String getVendor() {
        return vendor;
    }
}
