package org.example.consumer.repository;

import org.example.consumer.model.AircraftDataDto;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class AircraftRepository {
    private final ConcurrentHashMap<String, AircraftDataDto> aircraftStore = new ConcurrentHashMap<>();
    
    public boolean save(AircraftDataDto aircraft) {
        aircraft.setLastUpdated(System.currentTimeMillis());
        AircraftDataDto previous = aircraftStore.put(aircraft.getCallSign(), aircraft);
        return previous != null;
    }
    
    public AircraftDataDto findByCallSign(String callSign) {
        return aircraftStore.get(callSign);
    }
    
    public List<AircraftDataDto> findAll() {
        return new ArrayList<>(aircraftStore.values());
    }
    
    public boolean exists(String callSign) {
        return aircraftStore.containsKey(callSign);
    }
    
    public int removeOldAircraft(long cutoffTime) {
        List<String> toRemove = aircraftStore.values().stream()
                .filter(aircraft -> aircraft.getLastUpdated() < cutoffTime)
                .map(AircraftDataDto::getCallSign)
                .collect(Collectors.toList());
        
        toRemove.forEach(aircraftStore::remove);
        return toRemove.size();
    }
}
