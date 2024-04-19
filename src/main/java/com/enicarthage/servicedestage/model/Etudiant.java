package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Etudiant extends Utilisateur{


    private Long tel ;
    private String specialite ;
    private String encadrant ;
    private Date datePfe;

    public Etudiant(String nom, String email, String password, Long tel, String specialite, String encadrant, Date datePfe) {
        super(nom, email, password);
        this.tel = tel ;
        this.specialite = specialite;
        this.encadrant = encadrant;
        this.datePfe = datePfe ;
    }

    @OneToMany(mappedBy = "etudiant")
    private List<Tache> taches;

    @ManyToMany
    @JoinTable(
            name = "etudiant_evenement",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "evenement_id")
    )
    private Set<Evenement> evenements = new HashSet<>();

}
