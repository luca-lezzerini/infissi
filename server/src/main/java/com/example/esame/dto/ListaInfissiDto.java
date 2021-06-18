package com.example.esame.dto;

import com.example.esame.model.Infisso;
import java.util.ArrayList;
import java.util.List;

public class ListaInfissiDto {

    private List<Infisso> listaInfissi = new ArrayList<>();
    private Boolean errore = false;
    private String messaggioErrore = "";

    public ListaInfissiDto() {
    }

    public ListaInfissiDto(Boolean errore, String messaggioErrore) {
        this.errore = errore;
        this.messaggioErrore = messaggioErrore;
    }

    public ListaInfissiDto(List<Infisso> listaInfissi) {
        this.listaInfissi = listaInfissi;
    }

    public List<Infisso> getListaInfissi() {
        return listaInfissi;
    }

    public void setListaInfissi(List<Infisso> listaInfissi) {
        this.listaInfissi = listaInfissi;
    }

    public Boolean getErrore() {
        return errore;
    }

    public void setErrore(Boolean errore) {
        this.errore = errore;
    }

    public String getMessaggioErrore() {
        return messaggioErrore;
    }

    public void setMessaggioErrore(String messaggioErrore) {
        this.messaggioErrore = messaggioErrore;
    }

    @Override
    public String toString() {
        return "ListaInfissiDto{" + "listaInfissi=" + listaInfissi + '}';
    }

}
