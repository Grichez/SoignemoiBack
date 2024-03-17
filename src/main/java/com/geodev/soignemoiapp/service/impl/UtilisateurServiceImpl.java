package com.geodev.soignemoiapp.service.impl;

import com.geodev.soignemoiapp.pojo.Utilisateur;
import com.geodev.soignemoiapp.repository.UtilisateurRepository;
import com.geodev.soignemoiapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void modifierUtilisateurParId(Utilisateur utilisateur, Long id) {
        // Recupération de l'utilisateur
        Utilisateur utilisateurAModifier = this.trouverUtilisateurParId(id);
        // verifier que l'utilisateur à modifier n'est pas vide
        if (utilisateurAModifier != null) {
            // Mise à jour des champs
            utilisateurAModifier.setNom(utilisateur.getNom());
            utilisateurAModifier.setPrenom(utilisateur.getPrenom());
            utilisateurAModifier.setEmail(utilisateur.getEmail());
            utilisateurAModifier.setAdressePostal(utilisateur.getAdressePostal());
            utilisateurAModifier.setVille(utilisateur.getVille());
            utilisateurAModifier.setCodePostal(utilisateur.getCodePostal());
            utilisateurAModifier.setUtilsateurMDP(utilisateur.getUtilsateurMDP());

            utilisateurRepository.save(utilisateurAModifier);
        }
    }

    @Override
    public Utilisateur trouverUtilisateurParId(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }
}
