package com.statementlabs.parking_api.infrastructure.repository;

import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface JpaParkingSpotRepository extends JpaRepository<ParkingSpotEntity, Long> {
    Optional<ParkingSpotEntity> findFirstByStatus(SpotStatus status);
    List<ParkingSpotEntity> findAllByStatus(SpotStatus status);
}