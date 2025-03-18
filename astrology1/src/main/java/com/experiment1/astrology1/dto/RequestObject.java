package com.experiment1.astrology1.dto;


import lombok.*;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RequestObject {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int min;
    private double lat;
    private double lon;
    private final double tzone =5.5 ;

}
