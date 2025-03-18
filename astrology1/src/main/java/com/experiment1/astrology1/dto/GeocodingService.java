//package com.experiment1.astrology1.dto;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import org.springframework.web.client.RestTemplate;
//
//public class GeocodingService {
//
//    public String getCoordinates(String placeName) {
//        final RestTemplate restTemplate = new RestTemplate();
//        String url = "https://nominatim.openstreetmap.org/search?q=" + placeName + "&format=json";
//        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
//
//        if (response != null && response.isArray() && response.size() > 0) {
//            JsonNode location = response.get(0);
//            double lat = location.get("lat").asDouble();
//            double lon = location.get("lon").asDouble();
//            return "Latitude: " + lat + ", Longitude: " + lon;
//        }
//        return "Location not found!";
//    }
//
//    public static void main(String[] args){
//        GeocodingService geocodingService = new GeocodingService();
//        System.out.println(geocodingService.getCoordinates("Kalyandurg"));
//    }
//}
//
//
//
//
