package com.statementlabs.parking_api.presentation.controller;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.presentation.dto.ParkingSpotDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/spots")
public class ParkingSpotController {

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotController(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @GetMapping
    public List<ParkingSpotDTO> getAllSpots() {
        return parkingSpotRepository.findAll()
                .stream()
                .map(spot -> new ParkingSpotDTO(spot.getId(), spot.getStatus()))
                .toList();
    }

    @GetMapping("/available")
    public List<ParkingSpotDTO> getAvailableSpots() {
        return parkingSpotRepository.findAvailable()
                .stream()
                .map(spot -> new ParkingSpotDTO(spot.getId(), spot.getStatus()))
                .toList();
    }
}