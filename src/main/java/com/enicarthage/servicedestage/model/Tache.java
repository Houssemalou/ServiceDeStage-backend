package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String titre ;
    private Date date_debut ;
    private  Date date_fin ;
    @Enumerated(EnumType.STRING)
    private EtatTache etat ;
    @Enumerated(EnumType.STRING)
    private PrioriteTache priorite ;


}
