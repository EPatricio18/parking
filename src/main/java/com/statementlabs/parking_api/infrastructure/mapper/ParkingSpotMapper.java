package com.parking_api.infrastructure.persistence.mapper;

import com.parking_api.domain.model.ParkingSpot;
import com.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;

public class PersistenceParkingSpotMapper {

    public static ParkingSpot toDomain(ParkingSpotEntity entity) {
        if (entity == null) return null;
        return new ParkingSpot(
            entity.getId(),
            entity.getStatus()
        );
    }

    public static ParkingSpotEntity toEntity(ParkingSpot domain) {
        if (domain == null) return null;
        ParkingSpotEntity entity = new ParkingSpotEntity();
        entity.setId(domain.getId());
        entity.setStatus(domain.getStatus());
        return entity;
    }
}