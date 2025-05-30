package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;

@Service
public class PingService {

    public String ping() {
        return "pong";
    }
}
