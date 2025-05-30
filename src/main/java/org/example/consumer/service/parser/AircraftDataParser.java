package org.example.consumer.service.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.consumer.model.AircraftDataDto;
import org.springframework.stereotype.Component;

@Component
public class AircraftDataParser {
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public AircraftDataDto parse(String message) throws Exception {
        try {
            JsonNode root = objectMapper.readTree(message);
        
        String departureAirport = extractDepartureAirport(root);
        String destinationAirport = extractDestinationAirport(root);
        String aircraftType = extractAircraftType(root);
        String callSign = extractCallSign(root);
        String airport = extractAirport(root);
        int altitude = extractAltitude(root);
        String status = extractStatus(root);
        int velocityY = extractVelocityY(root);
        double longitude = extractLongitude(root);
        double latitude = extractLatitude(root);
        int velocityX = extractVelocityX(root);
        String trackNum = extractTrackNum(root);
        
        return AircraftDataDto.builder()
                .departureAirport(departureAirport)
                .destinationAirport(destinationAirport)
                .aircraftType(aircraftType)
                .callSign(callSign)
                .airport(airport)
                .altitude(altitude)
                .status(status)
                .velocityY(velocityY)
                .longitude(longitude)
                .latitude(latitude)
                .velocityX(velocityX)
                .trackNum(trackNum)
                .build();
        } catch (Exception e) {
            throw new Exception("[PARSE] Failed to parse aircraft data: " + e.getMessage());
        }
    }
    
    private String extractDepartureAirport(JsonNode root) {
        JsonNode enhanced = root.path("enhanced");
        return enhanced.isMissingNode() ? "N/A" : enhanced.path("departureAirport").asText("N/A");
    }
    
    private String extractDestinationAirport(JsonNode root) {
        JsonNode enhanced = root.path("enhanced");
        return enhanced.isMissingNode() ? "N/A" : enhanced.path("destinationAirport").asText("N/A");
    }
    
    private String extractAircraftType(JsonNode root) {
        JsonNode flightPlan = root.path("flightPlan");
        return flightPlan.isMissingNode() ? "N/A" : flightPlan.path("aircraftType").asText("N/A");
    }
    
    private String extractCallSign(JsonNode root) {
        JsonNode flightPlan = root.path("flightPlan");
        return flightPlan.isMissingNode() ? "N/A" : flightPlan.path("callSign").asText("N/A");
    }
    
    private String extractAirport(JsonNode root) {
        JsonNode flightPlan = root.path("flightPlan");
        return flightPlan.isMissingNode() ? "N/A" : flightPlan.path("airport").asText("N/A");
    }
    
    private int extractAltitude(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? 0 : track.path("altitude").asInt(0);
    }
    
    private String extractStatus(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? "N/A" : track.path("status").asText("N/A");
    }
    
    private int extractVelocityY(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? 0 : track.path("velocityY").asInt(0);
    }
    
    private double extractLongitude(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? 0.0 : track.path("longitude").asDouble(0.0);
    }
    
    private double extractLatitude(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? 0.0 : track.path("latitude").asDouble(0.0);
    }
    
    private int extractVelocityX(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? 0 : track.path("velocityX").asInt(0);
    }
    
    private String extractTrackNum(JsonNode root) {
        JsonNode track = root.path("track");
        return track.isMissingNode() ? "N/A" : track.path("trackNum").asText("N/A");
    }
}
