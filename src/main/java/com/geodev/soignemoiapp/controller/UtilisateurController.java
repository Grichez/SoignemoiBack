package com.geodev.soignemoiapp.controller;

import com.geodev.soignemoiapp.pojo.Utilisateur;
import com.geodev.soignemoiapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    void creerUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurService.creerUtilisateur(utilisateur);
    }
}
