package com.enicarthage.servicedestage.model;

public enum PrioriteTache { Elevee("Elevée") , Moyenne("moyenne") , Faibel("faible") ;
    private final String label;

    PrioriteTache(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }

}
