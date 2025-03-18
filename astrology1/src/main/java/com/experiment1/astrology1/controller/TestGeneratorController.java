package com.experiment1.astrology1.controller;

import com.experiment1.astrology1.dto.RequestObject;
import com.experiment1.astrology1.dto.UserDetails;
import com.experiment1.astrology1.service.GeocodingService;
import com.experiment1.astrology1.service.UserDetailsMappingService;
import com.experiment1.astrology1.service.WebClientConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        return userDetails;
    }

    @GetMapping("/display-request-object")
    // /details/display-request-object
    public RequestObject displayRequestObject(){
        RequestObject requestObject = mappingService.convertToRequestObject(userDetails);
        System.out.println(requestObject);
        return requestObject;
    }


    @GetMapping("/display-response-object")
    // /details/display-response-object
    public Mono<String> displayResponseObject() throws JsonProcessingException {
        RequestObject requestObject = mappingService.convertToRequestObject(userDetails);
        System.out.println(requestObject);

        // Define JSON request body
//    String jsonRequestBody = """
//        {
//        "day": 16,
//        "month": 10,
//        "year": 1972,
//        "hour": 7,
//        "min": 45,
//        "lat": 19.132,
//        "lon": 72.342,
//        "tzone": 5.5
//       }""";

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(requestObject);

        System.out.println(jsonRequestBody);

        this.endPoint = "astro_details";
        Mono<String> response = webClientConfig.apiRequestCall(endPoint, jsonRequestBody);
        return response;
    }


}
