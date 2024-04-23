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
public class InfoPfeEtudiant {

    @Id
    @GeneratedValue
    private Long id_Info;
    private String nom;
    private String email;
    private Long tel;
    private String specialite;
    private String encadrant;
    private Date datePfe;

}
