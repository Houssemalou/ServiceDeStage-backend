package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Partenaire;
import com.enicarthage.servicedestage.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
    Tache findById(long id);


    @Override
    <S extends Partenaire> S save(S partenaire);

    void deleteById(long id);


    boolean existsById(long id);


    List<Partenaire> findAll();
}

