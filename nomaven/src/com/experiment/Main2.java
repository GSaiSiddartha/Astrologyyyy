package com.experiment;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.*;

public class Main2 {
    public static void main(String[] args) {
        try {
            String url = "https://json.freeastrologyapi.com/d60-chart-info";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Setting request method
            connection.setRequestMethod("POST"); // Use POST to send body

            // Setting headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH");
           // connection.setRequestProperty("Authorization", "Bearer YOUR_TOKEN");

            // Enable output for request body
            connection.setDoOutput(true);

            System.out.println(connection);

            // JSON Body Data
            String jsonInputString = "{"
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

            System.out.println(jsonInputString);

            // Sending JSON data in the request body
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Reading the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Printing the response
                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("POST request failed with code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

