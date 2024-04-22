package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {


    Tache findTacheById(long id);


    @Override
    <S extends Tache> S save(S tache);

    void deleteById(long id);


    boolean existsById(long id);


    List<Tache> findAll();


}

