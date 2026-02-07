package presentation.controller;

import application.port.ParkingSpotRepository;
import domain.ParkingSpot;
import domain.SpotStatus;
import presentation.dto.ParkingSpotDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ParkingSpotController {

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotController(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @GetMapping("/spots")
    public List<ParkingSpotDTO> getAllSpots() {
        return parkingSpotRepository.findAll()
                .stream()
                .map(spot -> new ParkingSpotDTO(spot.getId(), spot.getStatus()))
                .collect(Collectors.toList());
    }

    @GetMapping("/spots/available")
    public List<ParkingSpotDTO> getAvailableSpots() {
        return parkingSpotRepository.findAll()
                .stream()
                .filter(spot -> spot.getStatus() == SpotStatus.FREE)
                .map(spot -> new ParkingSpotDTO(spot.getId(), spot.getStatus()))
                .collect(Collectors.toList());
    }
}