package com.geodev.soignemoiapi.controller;

import com.geodev.soignemoiapi.pojo.Medecin;
import com.geodev.soignemoiapi.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.API_MEDECIN)
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @PostMapping
    void creerMedecin(@RequestBody Medecin medecin){
        medecinService.creerMedecin(medecin);
    }

    @PutMapping("/{id}")
    void modifierMedecinParId(@RequestBody Medecin medecin, @PathVariable("id") Long id){
        medecinService.modifierMedecin(medecin,id);
    }

    @GetMapping(ApiRegistration.API_MEDECIN_SPECIALITE)
    List<Medecin> listerMedecinSpecialite(@RequestBody String specialite){
        return medecinService.listerMedecinParSpecialite(specialite);
    }
}
