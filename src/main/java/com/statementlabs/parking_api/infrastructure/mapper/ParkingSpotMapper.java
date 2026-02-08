package com.statementlabs.parking_api.infrastructure.mapper;

import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotMapper {

    public ParkingSpot toDomain(ParkingSpotEntity entity) {
        if (entity == null) return null;
        return new ParkingSpot(
                entity.getId(),
                SpotStatus.valueOf(entity.getStatus())
        );
    }

    public ParkingSpotEntity toEntity(ParkingSpot domain) {
        if (domain == null) return null;

        ParkingSpotEntity entity = new ParkingSpotEntity();
        
        entity.setId(domain.getId());
        
        entity.setStatus(domain.getStatus().name());

        return entity;
    }
}