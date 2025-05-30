package org.example.consumer.model;

import lombok.Data;

import java.time.Instant;

@Data
public class AircraftData {
    private Enhanced enhanced;
    private String messageType;
    private FlightPlan flightPlan;
    private Record record;
    private String source;
    private Track track;
    private long timestamp;

    @Data
    public static class Enhanced {
        private String departureAirport;
        private String destinationAirport;
    }

    @Data
    public static class FlightPlan {
        private String aircraftType;
        private int assignedAltitude;
        private String entryFix;
        private int requestedAltitude;
        private String flightRules;
        private String callSign;
        private String airport;
        private String exitFix;
    }

    @Data
    public static class Record {
        private String seqNum;
        private String source;
        private String type;
    }

    @Data
    public static class Track {
        private int altitude;
        private String beaconCode;
        private String trackNum;
        private int verticalVelocity;
        private double latitude;
        private int velocityX;
        private String time;
        private int velocityY;
        private String status;
        private double longitude;
    }
}