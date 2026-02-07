package com.statementlabs.parking_api.application.port;

import com.statementlabs.parking_api.domain.ParkingSpot;

import java.util.Optional;

import java.util.List;

public interface ParkingSpotRepository {
    List<ParkingSpot> findAll();
    List<ParkingSpot> findAvailable();
    Optional<ParkingSpot> findById(Long id);
    Optional<ParkingSpot> findFirstFree();
    void save(ParkingSpot spot);
    long count();
}
