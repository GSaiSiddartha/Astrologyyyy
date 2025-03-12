package com.experiment;


import okhttp3.*;
import java.io.IOException;

public class OkHttpPostExample {
    public static void main(String[] args) {
        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Define JSON body as a string
        String jsonBody = "{"
                + "\"year\": 1976,"
                + "\"month\": 6,"
                + "\"date\": 10,"
                + "\"hours\": 11,"
                + "\"minutes\": 10,"
                + "\"seconds\": 0,"
                + "\"latitude\": 18.933,"
                + "\"longitude\": 72.8166,"
                + "\"timezone\": 5.5,"
                + "\"config\": {"
                + "\"observation_point\": \"topocentric\","
                + "\"ayanamsha\": \"lahiri\""
                + "}"
                + "}";

        // Create a RequestBody with JSON type
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json; charset=utf-8"));

        // Build the request
        Request request = new Request.Builder()
                .url("https://json.freeastrologyapi.com/d60-chart-info")  // API endpoint
                .post(body) // Use POST method
                .addHeader("Content-Type", "application/json")  // Set Content-Type
                .addHeader("X-API-Key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")  // Add X-API-Key
                //.addHeader("Authorization", "Bearer YOUR_TOKEN")  // Add Bearer Token
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Response: " + response.body().string());
            } else {
                System.out.println("Request failed with code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
