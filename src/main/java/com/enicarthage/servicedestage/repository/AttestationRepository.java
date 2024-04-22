package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Attestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttestationRepository extends JpaRepository<Attestation, Long> {


    Attestation findById(long id);
    @Override
    <S extends Attestation> S save(S attestation);
    void deleteById(long id);
    boolean existsById(long id);
}

