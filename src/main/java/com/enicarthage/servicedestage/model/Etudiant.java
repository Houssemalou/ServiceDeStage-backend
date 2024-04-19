package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String nom ;
    private String email ;
    private Long tel ;
    private String specialite ;
    private String encadrant ;
    private Date datePfe;

    @OneToMany(mappedBy = "etudiant")
    private List<Tache> taches;

}
