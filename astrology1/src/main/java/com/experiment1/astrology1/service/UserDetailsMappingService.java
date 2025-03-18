package com.experiment1.astrology1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.experiment1.astrology1.dto.RequestObject;
import com.experiment1.astrology1.dto.UserDetails;

import java.util.Arrays;

@Service
public class UserDetailsMappingService {

    private int getDay(String date) {
        return Integer.parseInt(date.split("-")[2]);
    }

    private int getMonth(String date) {
        return Integer.parseInt(date.split("-")[1]);
    }

    private int getYear(String date) {
        return Integer.parseInt(date.split("-")[0]);
    }

    private int getHour(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    private int getMinute(String time) {
        return Integer.parseInt(time.split(":")[1]);
    }

    @Autowired
    private GeocodingService geocodingService;

    public RequestObject convertToRequestObject(UserDetails userDetails) {
        System.out.println("In UserDetailsMappingService displaying user details"+userDetails.getPlaceOfBirth());
        double[] coordinates = geocodingService.getCoordinates(userDetails.getPlaceOfBirth());
        System.out.println("In UserDetailsMappingService displaying coordinates"+ Arrays.toString(coordinates));
        return new RequestObject(
                getDay(userDetails.getDateOfBirth()),
                getMonth(userDetails.getDateOfBirth()),
                getYear(userDetails.getDateOfBirth()),
                getHour(userDetails.getTimeOfBirth()),
                getMinute(userDetails.getTimeOfBirth()),
                coordinates[0], // Latitude
                coordinates[1] // Longitude
        );
    }


}
