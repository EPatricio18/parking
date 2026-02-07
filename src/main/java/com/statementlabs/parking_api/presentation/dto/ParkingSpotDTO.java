package com.statementlabs.parking_api.presentation.dto;

import com.statementlabs.parking_api.domain.SpotStatus;

public record ParkingSpotDTO(Long id, SpotStatus status) {}