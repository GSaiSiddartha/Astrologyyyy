package com.experiment1.astrology1.controller;

import com.experiment1.astrology1.dto.RequestObject;
import com.experiment1.astrology1.dto.UserDetails;
import com.experiment1.astrology1.service.GeocodingService;
import com.experiment1.astrology1.service.UserDetailsMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*") // Allow cross-origin requests if needed
public class TestGeneratorController {

    private UserDetails userDetails;

    @Autowired
    private UserDetailsMappingService mappingService;

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


}
