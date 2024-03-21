package com.geodev.soignemoiapp.controller;

import com.geodev.soignemoiapp.pojo.Patient;
import com.geodev.soignemoiapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.API_PATIENT)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    void creerPatient(@RequestBody Patient patient){
        patientService.creerPatient(patient);
    }
}
