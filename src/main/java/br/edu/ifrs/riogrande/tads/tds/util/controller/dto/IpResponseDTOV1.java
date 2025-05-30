package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

import java.util.List;

public class IpResponseDTOV1 {
    public static IpResponseDTOV1 of(List<String> ips) {
        return new IpResponseDTOV1(ips);
    }

    private final int version = 1;
    private final List<String> ips;

    private IpResponseDTOV1(List<String> ips) {
        this.ips = ips;
    }

    public int getVersion() {
        return version;
    }

    public List<String> getIps() {
        return ips;
    }
}