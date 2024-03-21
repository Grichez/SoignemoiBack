package com.geodev.soignemoiapp.service.impl;

import com.geodev.soignemoiapp.pojo.Medecin;
import com.geodev.soignemoiapp.repository.MedecinRepository;
import com.geodev.soignemoiapp.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinServiceImpl implements MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public void creerMedecin(Medecin medecin) {
        medecinRepository.save(medecin);
    }

    @Override
    public void modifierMedecin(Medecin medecin, Long id) {
        Medecin medecinAModifier = this.trouverMedecinParId(id);
        if (medecinAModifier != null) {
            medecinAModifier.setNom(medecin.getNom());
            medecinAModifier.setPrenom(medecin.getPrenom());
            medecinAModifier.setSpecialite(medecin.getSpecialite());
            medecinAModifier.setMatricule(medecin.getMatricule());
//            medecinAModifier.setMedecinMDP(medecin.getMedecinMDP());
            medecinRepository.save(medecinAModifier);
        }
    }

    @Override
    public void supprimerMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

    @Override
    public Medecin trouverMedecinParId(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medecin> listerMedecinParSpecialite(String specialite) {
        return medecinRepository.RechercherMedecinParSpecialite(specialite);
    }
}
