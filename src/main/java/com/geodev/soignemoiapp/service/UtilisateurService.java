package com.geodev.soignemoiapp.service;

import com.geodev.soignemoiapp.pojo.Utilisateur;

public interface UtilisateurService {

    void creerUtilisateur(Utilisateur utilisateur);

    void modifierUtilisateurParId(Utilisateur utilisateur,Long id);

    Utilisateur trouverUtilisateurParId(Long id);
}
