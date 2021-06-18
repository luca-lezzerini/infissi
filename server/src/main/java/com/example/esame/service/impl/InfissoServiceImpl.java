package com.example.esame.service.impl;

import com.example.esame.ModelloDuplicatoException;
import com.example.esame.dto.ListaInfissiDto;
import com.example.esame.model.Infisso;
import com.example.esame.repository.InfissoRepository;
import com.example.esame.service.InfissoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfissoServiceImpl implements InfissoService {

    @Autowired
    InfissoRepository infissoRepository;

    @Transactional
    @Override
    public List<Infisso> salvaNuovo(Infisso infisso) throws ModelloDuplicatoException {
        if (checkModello(infisso.getModello()) == null) {
            infisso = infissoRepository.save(infisso);
            return getAllInfisso();
        } else {
            throw new ModelloDuplicatoException();
        }
    }

    @Transactional
    @Override
    public List<Infisso> salvaModifica(Infisso infisso) throws ModelloDuplicatoException {
        Infisso ix = checkModello(infisso.getModello());
        if (ix == null || ix.getId().equals(infisso.getId())) {
            infisso = infissoRepository.save(infisso);
            return getAllInfisso();
        } else {
            throw new ModelloDuplicatoException();
        }
    }

    @Transactional
    @Override
    public List<Infisso> deleteInfisso(Infisso infisso) {
        infissoRepository.delete(infisso);
        return getAllInfisso();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    @Override
    public List<Infisso> aggiorna() {
        return getAllInfisso();
    }

    private List<Infisso> getAllInfisso() {
        return infissoRepository.findAll();
    }

    private Infisso checkModello(String modello) {
        return infissoRepository.findByModello(modello);
    }

}
