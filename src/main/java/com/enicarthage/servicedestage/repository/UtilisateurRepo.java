package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    UtilisateurRepo findUtilisateurByNom(String nom);
}
