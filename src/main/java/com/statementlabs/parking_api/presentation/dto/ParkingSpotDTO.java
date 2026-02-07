package presentation.dto;

import domain.SpotStatus;

public record ParkingSpotDTO(Long id, SpotStatus status) {}