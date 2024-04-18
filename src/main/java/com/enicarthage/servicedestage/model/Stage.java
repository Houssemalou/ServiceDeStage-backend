package com.enicarthage.servicedestage.model;
import jakarta.persistence.*;

import lombok.*;


@Entity
public class Stage {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Partenaire partenaire;

    @Column
    private String description;

    @Column
    private int duree;

    @Column
    private int nbreplaces;
}
