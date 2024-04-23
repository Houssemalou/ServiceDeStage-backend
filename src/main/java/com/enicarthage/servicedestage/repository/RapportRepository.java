package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {


    Rapport findById(long id);
    @Override

    <S extends Rapport> S save(S rapport);

    void deleteById(long id);
    boolean existsById(long id);
}

