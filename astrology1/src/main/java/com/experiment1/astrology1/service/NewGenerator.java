package com.experiment1.astrology1.service;

import com.experiment1.astrology1.dto.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Base64;

@Service
public class NewGenerator {
    public Mono<String> newGeneratorMethod(){

        String username = "638486";
        String password = "c2308fbe0e38b845ff56b9719cdd9c58704a5a8b";
        String basicAuthHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        System.out.println(basicAuthHeader);

        // Create WebClient instance
        WebClient client = WebClient.builder()
                .baseUrl("https://json.astrologyapi.com/v1/planets")
                .defaultHeader("Authorization", basicAuthHeader) // Add Basic Auth header
                .defaultHeader("Content-Type", "application/json") // Set Content-Type
                .build();

        // Define JSON request body
        String jsonRequestBody = """ 
        {
        "day": 6,
        "month": 1,
        "year": 2000,
        "hour": 7,
        "min": 45,
        "lat": 19.132,
        "lon": 72.342,
        "tzone": 5.5
       }""";

        // Send POST request with JSON body
        Mono<String> response = client.post()
                .bodyValue(jsonRequestBody)  // Attach JSON body
                .retrieve()
                .bodyToMono(String.class);

        // Print response asynchronously
        response.subscribe(System.out::println);

        return response;

    }
}
