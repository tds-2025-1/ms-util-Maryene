package br.edu.ifrs.riogrande.tads.tds.util.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class IpService {

    public String generateUniqueIps(String baseIp) {
        if (!baseIp.matches("^(\\d{1,3}\\.){3}\\d{1,3}$")) {
            throw new IllegalArgumentException("Formato de IP inválido. Use como exemplo: 192.168.1.1");
        }

        String[] parts = baseIp.split("\\.");
        String network = parts[0] + "." + parts[1] + "." + parts[2] + ".";
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        // Gera 5 IPs únicos
        for (int i = 0; i < 5; i++) {
            int lastOctet = random.nextInt(254) + 1; // 1-254
            result.append(network).append(lastOctet);
            if (i < 4)
                result.append("\n");
        }

        return result.toString();
    }
}