package com.geodev.soignemoiapp.service.impl;

import com.geodev.soignemoiapp.pojo.Patient;
import com.geodev.soignemoiapp.repository.PatientRepository;
import com.geodev.soignemoiapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void creerPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void modifierPatientParId(Patient patient, Long id) {
        // Recupération de l'utilisateur
        Patient patientAModifier = this.trouverPatientParId(id);
        // verifier que l'utilisateur à modifier n'est pas vide
        if (patientAModifier != null) {
            // Mise à jour des champs
            patientAModifier.setNom(patient.getNom());
            patientAModifier.setPrenom(patient.getPrenom());
            patientAModifier.setAdressePostal(patient.getAdressePostal());
            patientAModifier.setVille(patient.getVille());
            patientAModifier.setCodePostal(patient.getCodePostal());

            patientRepository.save(patientAModifier);
        }
    }

    @Override
    public Patient trouverPatientParId(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
