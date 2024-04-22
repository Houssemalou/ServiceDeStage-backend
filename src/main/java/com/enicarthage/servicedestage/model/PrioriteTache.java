package com.enicarthage.servicedestage.model;

import lombok.Getter;


@Getter

public enum PrioriteTache { Elevee("Elevée") , Moyenne("moyenne") , Faibel("faible") ;
    private final String label;

    PrioriteTache(String label) {
        this.label = label;
    }


}
