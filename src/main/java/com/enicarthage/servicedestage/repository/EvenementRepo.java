package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Evenement;
import com.enicarthage.servicedestage.model.Stage;
import com.enicarthage.servicedestage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvenementRepo extends JpaRepository<Evenement, Long> {
    void deleteById(Long id);
    Optional<Evenement> findById(Long id);

    <S extends Evenement> S save(S entity);
    List<Evenement> findAll();

}
