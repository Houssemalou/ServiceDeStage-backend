package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Partenaire {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @Column
    private String email;

    @Column
    private String local;

    @OneToMany(mappedBy = "partenaire")
    private List<Stage> stages;
}