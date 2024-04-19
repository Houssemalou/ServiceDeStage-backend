package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.exception.EvenementNotFoundException;
import com.enicarthage.servicedestage.model.Evenement;
import com.enicarthage.servicedestage.repository.EvenementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {
    private final EvenementRepo evenementRepo;

    @Autowired
    public EvenementService(EvenementRepo evenementRepo) {
        this.evenementRepo = evenementRepo;
    }

    public Evenement addEvenement(Evenement evenement) {
        return evenementRepo.save(evenement);
    }

    public Evenement updateEvenement(Evenement evenement) {
        return evenementRepo.save(evenement);
    }

    public List<Evenement> findAllEvenements() {
        return evenementRepo.findAll();
    }

    public Evenement findEvenementById(Long id) {
        return evenementRepo.findById(id)
                .orElseThrow(() -> new EvenementNotFoundException("Evenement with id " + id + " not found"));
    }

    public void deleteEvenement(Long id) {
        evenementRepo.deleteById(id);
    }
}
