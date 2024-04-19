package com.enicarthage.servicedestage.service;

import com.enicarthage.servicedestage.exception.EtudiantNotFoundException;
import com.enicarthage.servicedestage.model.Etudiant;
import com.enicarthage.servicedestage.repository.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    private final EtudiantRepo etudiantRepo;

    @Autowired
    public EtudiantService(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    public Etudiant addEtudiant(Etudiant etudiant) {

        return (Etudiant) this.etudiantRepo.save(etudiant);
    }

    public Etudiant updateEtudiant(Etudiant etudiant) {

        return (Etudiant)this.etudiantRepo.save(etudiant);
    }

    public List<Etudiant> findAllEtudiants() {
        return etudiantRepo.findAll();
    }

    public Etudiant findEtudiantById(Long id) {
        return (Etudiant) this.etudiantRepo.findEtudiantById(id)
                .orElseThrow(() -> new EtudiantNotFoundException("Etudiant with id " + id + " not found"));
    }

    public void deleteEtudiant(Long id) {
        this.etudiantRepo.deleteEtudiantRepoById(id);
    }
}
