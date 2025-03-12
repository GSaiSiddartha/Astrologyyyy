package com.experiment1.astrology1.controller;


import com.experiment1.astrology1.dto.UserDetails;
import com.experiment1.astrology1.service.NewGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/report")
public class GeneraterController {

    public NewGenerator newgenerator;

    @Autowired
    public GeneraterController(NewGenerator newgenerator) {
        this.newgenerator = newgenerator;
    }


    @GetMapping("/generate")
    // /report/generate
    public Mono<String> reportController(){
        Mono<String> response = newgenerator.newGeneratorMethod();
        return response;
    }


}

