package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {


    Stage findById(long id);


    @Override
    <S extends Stage> S save(S stage);


    void deleteById(long id);


    boolean existsById(long id);


    List<Stage> findAll();


}


