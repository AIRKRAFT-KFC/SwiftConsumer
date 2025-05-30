package org.example.consumer.service;

import org.example.consumer.model.AircraftDataDto;
import org.example.consumer.repository.AircraftRepository;
import org.example.consumer.websocket.WebSocketService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AircraftBroadcastService {
    private final AircraftRepository aircraftRepository;
    private final WebSocketService webSocketService;
    
    public AircraftBroadcastService(AircraftRepository aircraftRepository, WebSocketService webSocketService) {
        this.aircraftRepository = aircraftRepository;
        this.webSocketService = webSocketService;
    }
    
    @Scheduled(fixedRate = 2000)
    public void broadcastAllAircraft() {
        List<AircraftDataDto> allAircraft = aircraftRepository.findAll();
        if (!allAircraft.isEmpty()) {
            webSocketService.sendAllAircraftData(allAircraft);
            System.out.println("[BROADCAST] " + allAircraft.size() + " aircraft sent");
        }
    }
}
