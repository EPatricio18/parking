package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import java.util.List;

public class GetParkingStatusUseCase {
    private final ParkingSpotRepository spotRepository;

    public GetParkingStatusUseCase(ParkingSpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public List<ParkingSpot> execute() {
        return spotRepository.findAll();
    }
}