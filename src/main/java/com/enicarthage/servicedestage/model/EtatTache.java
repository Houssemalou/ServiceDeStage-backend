package com.enicarthage.servicedestage.model;

public enum EtatTache {
    A_FAIRE("À faire"),
    EN_COURS("En cours"),
    TERMINE("Terminé");

    private final String label;

    EtatTache(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
