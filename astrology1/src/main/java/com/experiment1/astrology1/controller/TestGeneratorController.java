package com.experiment1.astrology1.controller;

import com.experiment1.astrology1.dto.RequestObject;
import com.experiment1.astrology1.dto.UserDetails;
import com.experiment1.astrology1.dto.response.Astro_Details;
import com.experiment1.astrology1.service.GeocodingService;
import com.experiment1.astrology1.service.JavaReqObjToJsonReqObj;
import com.experiment1.astrology1.service.UserDetailsMappingService;
import com.experiment1.astrology1.service.WebClientConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*") // Allow cross-origin requests if needed
public class TestGeneratorController {

    private UserDetails userDetails;

    @Autowired
    private UserDetailsMappingService mappingService;

    @Autowired
    private JavaReqObjToJsonReqObj javaReqObjToJsonReqObj;

    @Autowired
    public WebClientConfig webClientConfig;

    String endPoint;

    @PostMapping("/submit")
    // /details/submit
    public String receiveData(@RequestBody UserDetails userDetails) {
        this.userDetails=userDetails;
        System.out.println("In Controller: " + userDetails);
        return "Data received successfully!";
    }

    @GetMapping("/display-user-details")
    // /details/display-user-details
    public UserDetails displayData(){
//         String s = "{ \"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\" }";
//        String s1 = "{ \"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\" }";
        return userDetails;
    }

    @GetMapping("/display-request-object")
    // /details/display-request-object
    public RequestObject displayRequestObject(){
        RequestObject requestObject = mappingService.convertToRequestObject(userDetails);
        System.out.println("Displaying Req Obj in Controller at an end point "+requestObject);
        return requestObject;
    }


//    @GetMapping("/display-response-object")
//    // /details/display-response-object
//    public Mono<String> displayResponseObject() throws JsonProcessingException {
//        RequestObject requestObject = mappingService.convertToRequestObject(userDetails);
//        System.out.println("Received request object in CONTROLLER "+requestObject);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonRequestBody = objectMapper.writeValueAsString(requestObject);
//
//        System.out.println("Request Obj Successfully converted TO jSON "+jsonRequestBody);
//
//        this.endPoint = "astro_details";
//        Mono<String> response = webClientConfig.apiRequestCall(endPoint, jsonRequestBody);
//        return response;
//    }

    @GetMapping("/display-response-object")
    // /details/display-response-object
    public Mono<String> displayResponseObject() throws JsonProcessingException {

        this.endPoint = "astro_details";

        String jsonRequestBody = javaReqObjToJsonReqObj.returnJsonObject(userDetails);

        Mono<String> response = webClientConfig.apiRequestCall(endPoint, jsonRequestBody);

        Mono<Astro_Details> astroDetailsMono = response.map(jsonString -> new Gson().fromJson(jsonString, Astro_Details.class));

//        Gson gson = new Gson();
//
//        Astro_Details astroDetails = gson.fromJson(response, Astro_Details.class);

        //System.out.println(Mono<Astro_Details>);

        astroDetailsMono.subscribe(
                data -> System.out.println("Received: " + data),
                error -> System.err.println("Error: " + error) // Handle errors gracefully
        );

        return response;
    }

}
