package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EvenementRepo extends JpaRepository<Evenement, Long> {
    void deleteEvenementById(Long id);
    Optional<Evenement> findEvenementById(Long id);
}
