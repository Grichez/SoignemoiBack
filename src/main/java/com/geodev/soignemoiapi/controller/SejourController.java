package com.geodev.soignemoiapi.controller;

import com.geodev.soignemoiapi.pojo.Sejour;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.API_SEJOUR)
public class SejourController {

    @PostMapping
    void creerUnSejour(Sejour sejourACreer){

    }
}
