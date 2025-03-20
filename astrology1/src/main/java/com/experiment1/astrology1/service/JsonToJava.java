package com.experiment1.astrology1.service;

import com.google.gson.Gson;
import lombok.ToString;

public class JsonToJava {
    @ToString
    public class User {
        private String name;
        private int age;
        private String email;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
    public static void main(String[] args) {
        String json = "{ \"name\": \"John Doe\", \"age\": 30, \"email\": \"john.doe@example.com\" }";

        System.out.println(json);

        System.out.println(json instanceof String);

        Gson gson = new Gson();

        User user = gson.fromJson(json, User.class);

        System.out.println(user);
    }
}
