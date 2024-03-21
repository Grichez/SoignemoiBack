package com.geodev.soignemoiapi.service;

import com.geodev.soignemoiapi.pojo.Medecin;

import java.util.List;

public interface MedecinService {
    void creerMedecin(Medecin medecin);

    void modifierMedecin(Medecin medecin,Long id);

    void supprimerMedecin(Long id);

    Medecin trouverMedecinParId(Long id);

    List<Medecin> listerMedecinParSpecialite(String specialite);
}
