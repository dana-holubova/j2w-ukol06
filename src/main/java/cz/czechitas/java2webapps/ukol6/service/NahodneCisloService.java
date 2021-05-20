package cz.czechitas.java2webapps.ukol6.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NahodneCisloService {
    //    field
    private final Random random;

    //    konstruktor
    public NahodneCisloService() {
        this.random = new Random();
    }

    //    metoda pro vrácení náhodného čísla
    public int dejNahodneCislo(int horniMez) {
        return random.nextInt(horniMez);
    }
}
