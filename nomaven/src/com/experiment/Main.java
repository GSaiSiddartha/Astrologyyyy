package com.experiment;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "https://jsonplaceholder.typicode.com/posts";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Setting request method
            connection.setRequestMethod("GET");

            // Setting headers (if required)
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-api-key", "YOUR_API_KEY");
            // connection.setRequestProperty("Authorization", "Bearer YOUR_TOKEN");

            // Reading the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Printing the response
                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("GET request failed with code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}