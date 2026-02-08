package com.statementlabs.parking_api.presentation.controller;

import com.statementlabs.parking_api.application.usecase.GetParkingStatusUseCase;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.presentation.dto.ParkingSpotDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/spots")
public class ParkingSpotController {

    private final GetParkingStatusUseCase getParkingStatusUseCase;

    public ParkingSpotController(GetParkingStatusUseCase getParkingStatusUseCase) {
        this.getParkingStatusUseCase = getParkingStatusUseCase;
    }

    @GetMapping
    public List<ParkingSpotDTO> getAllSpots() {
        return getParkingStatusUseCase.execute()
                .stream()
                .map(spot -> new ParkingSpotDTO(spot.getId(), spot.getStatus()))
                .collect(Collectors.toList());
    }

    @GetMapping("/available")
    public List<ParkingSpotDTO> getAvailableSpots() {
        return getParkingStatusUseCase.execute()
                .stream()
                .filter(spot -> spot.getStatus() == SpotStatus.FREE)
                .map(spot -> new ParkingSpotDTO(spot.getId(), spot.getStatus()))
                .collect(Collectors.toList());
    }
}