package com.statementlabs.parking_api.presentation.mapper;

import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.presentation.dto.ParkingSpotDTO;

public class ParkingSpotMapper {

    public static ParkingSpotDTO toDTO(ParkingSpot domain) {
        if (domain == null) return null;
        return new ParkingSpotDTO(
            domain.getId(),
            domain.getStatus()
        );
    }
}