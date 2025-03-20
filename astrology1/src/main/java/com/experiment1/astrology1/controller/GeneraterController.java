package com.experiment1.astrology1.controller;


import com.experiment1.astrology1.dto.UserDetails;
import com.experiment1.astrology1.service.NewGenerator;
import com.experiment1.astrology1.service.WebClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/report")
public class GeneraterController {

//    @Autowired
//    public NewGenerator newgenerator;

    @Autowired
    public WebClientConfig webClientConfig;

    String endPoint;

    // Define JSON request body
    String jsonRequestBody = """ 
        {
        "day": 16,
        "month": 10,
        "year": 1972,
        "hour": 7,
        "min": 45,
        "lat": 19.132,
        "lon": 72.342,
        "tzone": 5.5
       }""";

//    @GetMapping("/generate-planets")
//    // /report/generate-planets
//    public Mono<String> planetReport(){
//         this.endPoint = "planets";
//        Mono<String> response = newgenerator.newGeneratorMethod(endPoint, jsonRequestBody);
//        return response;
//    }
//
//    @GetMapping("/generate-astro_details")
//    // /report/generate-astro_details
//    public Mono<String> astro_detailsReport(){
//        this.endPoint = "astro_details";
//        Mono<String> response = newgenerator.newGeneratorMethod(endPoint, jsonRequestBody);
//        return response;
//    }

//    @GetMapping("/generate-planets")
//    // /report/generate-planets
//    public Mono<String> planetReport(){
//        this.endPoint = "planets";
//        Mono<String> response = webClientConfig.apiRequestCall(endPoint, jsonRequestBody);
//        return response;
//    }
//
//    @GetMapping("/generate-astro_details")
//    // /report/generate-astro_details
//    public Mono<String> astro_detailsReport(){
//        this.endPoint = "astro_details";
//        Mono<String> response = webClientConfig.apiRequestCall(endPoint, jsonRequestBody);
//        return response;
//    }


}

