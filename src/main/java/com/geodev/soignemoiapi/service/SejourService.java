package com.geodev.soignemoiapi.service;

import com.geodev.soignemoiapi.pojo.Sejour;

import java.util.List;

public interface SejourService {

    void creerUnSejour(Sejour sejour);

    List<Sejour> listerSejourParPatient(Long patientId);
}
