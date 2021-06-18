package com.example.esame.service;

import com.example.esame.ModelloDuplicatoException;
import com.example.esame.dto.ListaInfissiDto;
import com.example.esame.model.Infisso;
import java.util.List;

public interface InfissoService {

    List<Infisso> salvaNuovo(Infisso infisso) throws ModelloDuplicatoException;

    List<Infisso> salvaModifica(Infisso infisso) throws ModelloDuplicatoException;

    List<Infisso> deleteInfisso(Infisso infisso);
    
    List<Infisso> aggiorna();
}
