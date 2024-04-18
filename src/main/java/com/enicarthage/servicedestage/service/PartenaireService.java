package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.model.Partenaire;
import com.enicarthage.servicedestage.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PartenaireService {

    @Autowired
    private PartenaireRepository partenaireRepository;

    public Partenaire savePartenaire(Partenaire partenaire) {
        return partenaireRepository.save(partenaire);
    }

    public List<Partenaire> getAllPartenaires() {
        return partenaireRepository.findAll();
    }

    public Optional<Partenaire> getPartenaireById(Long id) {
        return partenaireRepository.findById(id);
    }

    public void deletePartenaire(Long id) {
        partenaireRepository.deleteById(id);
    }
}

