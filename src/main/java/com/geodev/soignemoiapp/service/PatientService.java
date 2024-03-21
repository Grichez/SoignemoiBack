package com.geodev.soignemoiapp.service;

import com.geodev.soignemoiapp.pojo.Patient;

public interface PatientService {

    void creerPatient(Patient patient);

    void modifierPatientParId(Patient patient, Long id);

    Patient trouverPatientParId(Long id);
}
