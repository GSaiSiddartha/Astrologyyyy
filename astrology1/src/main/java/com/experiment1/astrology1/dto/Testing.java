package com.experiment1.astrology1.dto;

import com.experiment1.astrology1.service.WebClientConfig;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Testing {

//    public static double[] getCoordinates(String placeName) {
//        final RestTemplate restTemplate = new RestTemplate();
//        String url = "https://nominatim.openstreetmap.org/search?q=" + placeName + "&format=json";
//        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
//
//        if (response != null && response.isArray() && response.size() > 0) {
//            JsonNode location = response.get(0);
//            double lat = location.get("lat").asDouble();
//            double lon = location.get("lon").asDouble();
//            return new double[]{lat, lon};
//        }
//        return new double[]{0.0, 0.0}; // Default values if location not found
//    }
    public static void main(String[] args){
        RequestObject requestObject = new RequestObject(13,01,2000,13,30,14.5520,77.1107);
        System.out.println(requestObject);

        //WebClientConfig webClientConfig = new WebClientConfig();
//        String myStr = "2025-03-04";
//        String[] myArray = myStr.split("-");
//        System.out.println( Arrays.toString(myArray));
//
//        for (int i=0;i<myArray.length;i++){
//            System.out.println(myArray[i]);
//        }

        //System.out.println(Arrays.toString(getCoordinates("Mumbai")));


    }
}
