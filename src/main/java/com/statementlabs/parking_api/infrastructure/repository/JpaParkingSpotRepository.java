package com.statementlabs.parking_api.infrastructure.persistence.repository;

import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaParkingSpotRepository extends JpaRepository<ParkingSpotEntity, Integer> {

    Optional<ParkingSpotEntity> findFirstByStatus(String status);
}