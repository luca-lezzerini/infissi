package com.example.esame.dto;

import com.example.esame.model.Infisso;

public class InfissoDto {

    private Infisso infisso;

    public InfissoDto() {
    }

    public InfissoDto(Infisso infisso) {
        this.infisso = infisso;
    }

    public Infisso getInfisso() {
        return infisso;
    }

    public void setInfisso(Infisso infisso) {
        this.infisso = infisso;
    }

    @Override
    public String toString() {
        return "InfissoDto{" + "infisso=" + infisso + '}';
    }
    
    
}
