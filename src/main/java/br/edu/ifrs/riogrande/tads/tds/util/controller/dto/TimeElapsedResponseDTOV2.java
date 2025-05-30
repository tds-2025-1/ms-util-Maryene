package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

import java.time.LocalDateTime;

public class TimeElapsedResponseDTOV2 {

    private final int version = 2;
    private final String timestamp = LocalDateTime.now().toString();
    private final String vendor = "TADS";
    private final String elapsedTime;

    public TimeElapsedResponseDTOV2(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getVersion() {
        return version;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getVendor() {
        return vendor;
    }
}