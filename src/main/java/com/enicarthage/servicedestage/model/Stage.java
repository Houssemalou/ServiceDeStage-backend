package com.enicarthage.servicedestage.model;
import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Entity

public class Stage {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "partenaire_id")
    private Partenaire partenaire;

    @Column
    private String description;

    @Column
    private int duree;

    @Column
    private int nbreplaces;
}
