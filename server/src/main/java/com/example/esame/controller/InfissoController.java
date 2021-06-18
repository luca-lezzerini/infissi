package com.example.esame.controller;

import com.example.esame.ModelloDuplicatoException;
import com.example.esame.dto.InfissoDto;
import com.example.esame.dto.ListaInfissiDto;
import com.example.esame.service.InfissoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class InfissoController {

    @Autowired
    InfissoService infissoService;

    @RequestMapping("/salva-nuovo")
    @ResponseBody
    public ListaInfissiDto salvaNuovo(@RequestBody InfissoDto dto) {
        try {
            return new ListaInfissiDto(infissoService.salvaNuovo(dto.getInfisso()));
        } catch (ModelloDuplicatoException ex) {
            return new ListaInfissiDto(true, "Modello duplicato");
        }
    }

    @RequestMapping("/salva-modifica")
    @ResponseBody
    public ListaInfissiDto salvaModifica(@RequestBody InfissoDto dto) {
         try {
            return new ListaInfissiDto(infissoService.salvaModifica(dto.getInfisso()));
        } catch (ModelloDuplicatoException ex) {
            return new ListaInfissiDto(true, "Modello duplicato");
        }
    }

    @RequestMapping("/delete-infisso")
    @ResponseBody
    public ListaInfissiDto deleteInfisso(@RequestBody InfissoDto dto) {
        return new ListaInfissiDto(infissoService.deleteInfisso(dto.getInfisso()));
    }
    
    @RequestMapping("/aggiorna")
    @ResponseBody
    public ListaInfissiDto aggiorna() {
        return new ListaInfissiDto(infissoService.aggiorna());
    }
}
