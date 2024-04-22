package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {


    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @Column
    private String description;


    @OneToMany(mappedBy = "categorie")
    private List<Stage> stages;
}
