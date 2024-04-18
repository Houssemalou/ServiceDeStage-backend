package com.enicarthage.servicedestage.repository;

import com.enicarthage.servicedestage.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
}

