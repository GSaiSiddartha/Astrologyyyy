package com.experiment1.astrology1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonStringifyOrdered {
    public static void main(String[] args) {
        try {
            // Use LinkedHashMap to maintain order
            Map<String, Object> obj = new LinkedHashMap<>();

            // Adding key-value pairs in order
            obj.put("day", "6");
            obj.put("month", "1");
            obj.put("year", "2000");
            obj.put("hour", "7");
            obj.put("min", "45");
            obj.put("lat", "19.132");
            obj.put("lon", "72.342");
            obj.put("tzone", "5.5");

            System.out.println("Map Representation: " + obj);

            // Convert LinkedHashMap to JSON String using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(obj);

            // Print JSON String
            System.out.println("Ordered JSON Output: " + jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
