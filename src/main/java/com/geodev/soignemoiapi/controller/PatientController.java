package com.geodev.soignemoiapi.controller;

import com.geodev.soignemoiapi.pojo.Patient;
import com.geodev.soignemoiapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.API_PATIENT)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    void creerPatient(@RequestBody Patient patient){
        patientService.creerPatient(patient);
    }

    @PutMapping("/{id}")
    void modifierPatientParId(@RequestBody Patient patient, @PathVariable("id") Long id){
        patientService.modifierPatientParId(patient,id);
    }

}
