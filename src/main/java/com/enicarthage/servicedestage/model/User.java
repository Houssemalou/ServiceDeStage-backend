package com.enicarthage.servicedestage.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue
    private String email;
    @Column(unique = true)
    private String password;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Role role;

    


    @OneToMany(mappedBy = "etudiant")
    private List<Tache> taches;

    @OneToMany(mappedBy = "admin")
    private List<Evenement> evenements;

}
