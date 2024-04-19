package com.enicarthage.servicedestage.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends Utilisateur{
    public Admin(String nom, String email, String password) {
        super(nom, email, password);
    }
}
