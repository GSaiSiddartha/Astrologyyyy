package com.experiment1.astrology1.service;

import com.experiment1.astrology1.dto.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Base64;

@Service
public class NewGenerator {

    String username = "638486";
    String password = "c2308fbe0e38b845ff56b9719cdd9c58704a5a8b";
    String basicAuthHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

    //System.out.println(basicAuthHeader);

    // Create WebClient instance
    WebClient client = WebClient.builder()
            .baseUrl("https://json.astrologyapi.com/v1")
            .defaultHeader("Authorization", basicAuthHeader) // Add Basic Auth header
            .defaultHeader("Content-Type", "application/json") // Set Content-Type
            .build();

    public Mono<String> newGeneratorMethod(String endPoint, String jsonRequestBody){

        System.out.println(jsonRequestBody);

        // Send POST request with JSON body
        Mono<String> response = client.post()
                .uri("/"+endPoint)
                .bodyValue(jsonRequestBody)  // Attach JSON body
                .retrieve()
                .bodyToMono(String.class);

        // Print response asynchronously
        response.subscribe(System.out::println);

        return response;

    }
}
