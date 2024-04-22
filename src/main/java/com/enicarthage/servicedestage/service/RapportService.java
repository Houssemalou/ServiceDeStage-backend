package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Rapport;
import com.enicarthage.servicedestage.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    public Optional<Rapport> getRapportById(Long id) {
        return rapportRepository.findById(id);
    }

    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    public Rapport updateRapport(Long id, Rapport rapport) {
        if (rapportRepository.existsById(id)) {
            rapport.setId(id);
            return rapportRepository.save(rapport);
        }
        return null;
    }

    public void deleteRapport(Long id) {
        rapportRepository.deleteById(id);
    }
}


