package com.experiment1.astrology1.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Base64;

@Configuration
public class WebClientConfig {

    private final WebClient webClient;

    String username = "638486";
    String password = "c2308fbe0e38b845ff56b9719cdd9c58704a5a8b";
    String basicAuthHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());


    public WebClientConfig(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://json.astrologyapi.com/v1")
                .defaultHeader("Authorization", basicAuthHeader) // Add Basic Auth header
                .defaultHeader("Content-Type", "application/json") // Set Content-Type
                .build();
    }


//    public Mono<String> apiRequestCall(){
//        Mono<String> response = webClient.post()
//                .bodyValue(jsonRequestBody)  // Attach JSON body
//                .retrieve()
//                .bodyToMono(String.class);
//        return response;
//    }


}
