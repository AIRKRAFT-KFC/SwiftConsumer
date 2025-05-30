package org.example.consumer.service;

import org.example.consumer.repository.AircraftRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AircraftCleanupService {
    private final AircraftRepository aircraftRepository;
    
    public AircraftCleanupService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }
    
    @Scheduled(fixedRate = 30000)
    public void cleanupOldAircraft() {
        long cutoffTime = System.currentTimeMillis() - 120000;
        int removedCount = aircraftRepository.removeOldAircraft(cutoffTime);
        
        if (removedCount > 0) {
            System.out.println("[CLEANUP] Removed " + removedCount + " inactive aircraft (>2min)");
        }
    }
}
