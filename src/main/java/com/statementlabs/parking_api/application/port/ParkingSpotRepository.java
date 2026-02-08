package com.statementlabs.parking_api.application.port;

import com.statementlabs.parking_api.domain.ParkingSpot;
import java.util.Optional;
import java.util.List;

public interface ParkingSpotRepository {
    Optional<ParkingSpot> findFirstFree();
    Optional<ParkingSpot> findById(Long id);
    ParkingSpot save(ParkingSpot spot);
    List<ParkingSpot> findAll();
}