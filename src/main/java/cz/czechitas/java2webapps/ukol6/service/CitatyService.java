package cz.czechitas.java2webapps.ukol6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitatyService {
//    fieldy
private final NahodneCisloService nahodneCisloService;
private final CitatyRepository citatyRepository;

//konstruktor
//připojuji další dvě service
    @Autowired
public CitatyService(NahodneCisloService nahodneCisloService, CitatyRepository citatyRepository) {
        this.nahodneCisloService = nahodneCisloService;
        this.citatyRepository = citatyRepository;
    }

//    metoda pro vložení náhodného citátu
public String nahodnyCitat() {
       return citatyRepository.citat(nahodneCisloService.dejNahodneCislo(citatyRepository.pocet()));
}

//metoda pro návrácení konkrétního citátu
    public String konkretniCitat(int cislo) {
        return citatyRepository.citat(cislo);
    }

}
