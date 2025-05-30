package org.example.consumer.service;

import org.example.consumer.model.AircraftDataDto;
import org.example.consumer.service.parser.AircraftDataParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    
    private final AircraftDataParser parser;
    private final AircraftDataService aircraftDataService;
    
    public KafkaConsumerService(AircraftDataParser parser, AircraftDataService aircraftDataService) {
        this.parser = parser;
        this.aircraftDataService = aircraftDataService;
    }
    
    @Async
    @KafkaListener(topics = "${app.kafka.topic}", concurrency = "3")
    public void consume(String message) {
        try {
            AircraftDataDto aircraftData = parser.parse(message);
            aircraftDataService.processAircraftData(aircraftData);
        } catch (Exception e) {
            System.err.println("[ERROR] Kafka processing failed: " + e.getMessage());
        }
    }
}