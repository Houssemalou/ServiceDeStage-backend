package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Etudiant;
import com.enicarthage.servicedestage.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    void deleteEtudiantRepoById(Long id) ;
    Optional<Etudiant> findEtudiantById(Long id) ;
}
