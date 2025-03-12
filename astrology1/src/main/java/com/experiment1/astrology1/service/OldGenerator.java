package com.experiment1.astrology1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OldGenerator {

    public Mono<String> oldGeneratorMethod(){

        WebClient client = WebClient.builder()
                .baseUrl("https://json.freeastrologyapi.com/d60-chart-info")
               // .defaultHeader("Authorization", "Bearer YOUR_TOKEN")  // Add Authorization header
                .defaultHeader("Content-Type", "application/json")     // Add Content-Type header
                .defaultHeader("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")            // Add x-api-key header
                .build();

        // Define the JSON request body
        String jsonRequestBody = """
            {
                "year": 1976,
                "month": 6,
                "date": 10,
                "hours": 11,
                "minutes": 10,
                "seconds": 0,
                "latitude": 18.933,
                "longitude": 72.8166,
                "timezone": 5.5,
                "config": {
                    "observation_point": "topocentric",
                    "ayanamsha": "lahiri"
                }
            }
        """;

        // Send POST request with body
        Mono<String> response = client.post() // Change to POST request
                .bodyValue(jsonRequestBody)  // Attach JSON body
                .retrieve()
                .bodyToMono(String.class);

        // Print response asynchronously
        response.subscribe(System.out::println);
        return response;
    }



}
