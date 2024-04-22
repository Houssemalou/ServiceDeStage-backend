package com.enicarthage.servicedestage.model;

import lombok.Getter;

@Getter
public enum EtatTache {
    A_FAIRE("À faire"),
    EN_COURS("En cours"),
    TERMINE("Terminé");

    private final String label;

    EtatTache(String label) {
        this.label = label;
    }

}
