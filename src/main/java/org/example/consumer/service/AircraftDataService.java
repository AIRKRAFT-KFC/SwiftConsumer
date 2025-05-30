package org.example.consumer.service;

import org.example.consumer.model.AircraftDataDto;
import org.example.consumer.repository.AircraftRepository;
import org.example.consumer.websocket.WebSocketService;
import org.springframework.stereotype.Service;

@Service
public class AircraftDataService {
    private final AircraftRepository aircraftRepository;
    private final WebSocketService webSocketService;
    
    public AircraftDataService(AircraftRepository aircraftRepository, WebSocketService webSocketService) {
        this.aircraftRepository = aircraftRepository;
        this.webSocketService = webSocketService;
    }
    
    public void processAircraftData(AircraftDataDto aircraftData) {
        if (aircraftData.getCallSign() == null || "N/A".equals(aircraftData.getCallSign())) {
            System.err.println("[SKIP] Invalid callSign");
            return;
        }
        
        boolean wasUpdate = aircraftRepository.save(aircraftData);
        System.out.println("[" + (wasUpdate ? "UPDATE" : "NEW") + "] " + aircraftData.getCallSign() + " | Alt:" + aircraftData.getAltitude() + " | Status:" + aircraftData.getStatus());
    }
}
