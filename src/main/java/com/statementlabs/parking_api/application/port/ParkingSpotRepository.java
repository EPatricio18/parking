package com.statementlabs.parking_api.application.port;

import com.statementlabs.parking_api.domain.ParkingSpot;

import java.util.Optional;

public interface ParkingSpotRepository {

    Optional<ParkingSpot> findFirstFree();

    Optional<ParkingSpot> findById(int id);

    void save(ParkingSpot spot);
}
