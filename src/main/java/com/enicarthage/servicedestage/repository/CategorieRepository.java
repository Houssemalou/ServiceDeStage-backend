package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Categorie;
import com.enicarthage.servicedestage.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    void deleteCategorieRepoById(Long id) ;
    Optional<Categorie> findCategorieById(Long id) ;
}
