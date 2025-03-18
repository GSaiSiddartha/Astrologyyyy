package com.experiment1.astrology1.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate = new RestTemplate();

    public double[] getCoordinates(String placeName) {
        System.out.println("In GeocodingService displaying received location name"+ placeName);
        String url = "https://nominatim.openstreetmap.org/search?q=" + placeName + "&format=json";
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

        if (response != null && response.isArray() && response.size() > 0) {
            JsonNode location = response.get(0);
            double lat = location.get("lat").asDouble();
            double lon = location.get("lon").asDouble();
            return new double[]{lat, lon};
        }
        return new double[]{0.0, 0.0}; // Default values if location not found
    }
}
