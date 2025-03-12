package com.experiment1.astrology1.dto;

public class UserDetails {

    String fullName;
    String dateOfBirth;
    String timeOfBirth;
    String placeOfBirth;

    public UserDetails() {
    }

    public UserDetails(String fullName, String dateOfBirth, String timeOfBirth, String placeOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.timeOfBirth = timeOfBirth;
        this.placeOfBirth = placeOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(String timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", timeOfBirth='" + timeOfBirth + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                '}';
    }
}
