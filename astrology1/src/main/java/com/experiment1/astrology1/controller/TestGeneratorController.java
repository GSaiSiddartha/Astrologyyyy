package com.experiment1.astrology1.controller;

import com.experiment1.astrology1.dto.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*") // Allow cross-origin requests if needed
public class TestGeneratorController {

    public UserDetails userDetails;

    @PostMapping("/submit")
    // /details/submit
    public String receiveData(@RequestBody UserDetails userDetails) {
        this.userDetails=userDetails;
        System.out.println("In Controller: " + userDetails);
        return "Data received successfully!";
    }

    @GetMapping("/display")
    // /details/display
    public UserDetails displayData(){
        return userDetails;
    }


}
