package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

public class ForcaSenhaResponseDTOV1 {
    public static ForcaSenhaResponseDTOV1 of(String result) {
        return new ForcaSenhaResponseDTOV1(result);
    }

    private final int version = 1;
    private final String result;

    private ForcaSenhaResponseDTOV1(String result) {
        this.result = result;
    }

    public int getVersion() {
        return version;
    }

    public String getResult() {
        return result;
    }
}