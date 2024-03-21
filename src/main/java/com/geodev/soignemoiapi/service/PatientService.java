package com.geodev.soignemoiapi.service;

import com.geodev.soignemoiapi.pojo.Patient;

public interface PatientService {

    boolean creerPatient(Patient patient);

    void modifierPatientParId(Patient patient, Long id);

    Patient trouverPatientParId(Long id);

}
