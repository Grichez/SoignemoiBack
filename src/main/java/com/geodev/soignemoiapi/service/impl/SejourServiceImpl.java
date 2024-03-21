package com.geodev.soignemoiapi.service.impl;

import com.geodev.soignemoiapi.pojo.Sejour;
import com.geodev.soignemoiapi.repository.SejourRepository;
import com.geodev.soignemoiapi.service.SejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SejourServiceImpl implements SejourService {

    @Autowired
    private SejourRepository sejourRepository;

    @Override
    public void creerUnSejour(Sejour sejour) {
        sejourRepository.save(sejour);
    }

    @Override
    public List<Sejour> listerSejourParPatient(Long patientId) {
        return sejourRepository.listerSejourPatient(patientId);
    }

}
