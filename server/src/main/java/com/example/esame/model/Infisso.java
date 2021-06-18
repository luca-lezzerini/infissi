package com.example.esame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Infisso {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String modello = "";

    @Column
    private Double prezzo = 0.0;

    public Infisso() {
    }

    public Infisso(String modello, Double prezzo) {
        this.modello = modello;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Infisso{" + "id=" + id + ", modello=" + modello + ", prezzo=" + prezzo + '}';
    }
    
}
