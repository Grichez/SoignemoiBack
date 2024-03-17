package com.geodev.soignemoiapp.WebService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestWS {

    @GetMapping
    public String bonjour(){
        return "Bonjour";
    }
}
