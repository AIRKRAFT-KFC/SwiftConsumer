package org.example.consumer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AircraftDataDto {
    private String departureAirport;
    private String destinationAirport;
    private String aircraftType;
    private String callSign;
    private String airport;
    private int altitude;
    private String status;
    private int velocityY;
    private double longitude;
    private double latitude;
    private int velocityX;
    private String trackNum;
    private long lastUpdated;
}