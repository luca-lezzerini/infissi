package com.example.esame.repository;

import com.example.esame.model.Infisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfissoRepository extends JpaRepository<Infisso, Long> {

    Infisso findByModello(String modello);
}
