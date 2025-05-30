package br.edu.ifrs.riogrande.tads.tds.util.service;

import java.util.ArrayList;
import java.util.List;
import com.github.f4b6a3.uuid.UuidCreator;

import org.springframework.stereotype.Service;

@Service
public class UuidService {
    public List<String> generate(int noPasswords) {
        if (noPasswords < 1) {
            throw new IllegalArgumentException("Number of passwords must be at least 1");
        }
        if (noPasswords > 50) {
            throw new IllegalArgumentException("Number of passwords must be at most 50");
        }

        ArrayList<String> passwords = new ArrayList<String>();

        for (int i = 0; i < noPasswords; i++) {
            passwords.add(UuidCreator.getTimeOrderedEpoch().toString());
        }

        return passwords;
    }
}
