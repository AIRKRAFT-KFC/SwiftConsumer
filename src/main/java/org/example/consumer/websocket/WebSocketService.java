package org.example.consumer.websocket;

import org.example.consumer.model.AircraftDataDto;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendAllAircraftData(List<AircraftDataDto> aircraftList) {
        try {
            messagingTemplate.convertAndSend("/topic/aircraft-all", aircraftList);
        } catch (Exception e) {
            System.err.println("[ERROR] WebSocket broadcast failed: " + e.getMessage());
        }
    }
}