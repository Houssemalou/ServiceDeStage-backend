package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TacheRepo extends JpaRepository<Tache,Long> {
    void deleteTacheRepoById(Long id) ;
    Optional<Tache> findTacheById(Long id) ;
}
