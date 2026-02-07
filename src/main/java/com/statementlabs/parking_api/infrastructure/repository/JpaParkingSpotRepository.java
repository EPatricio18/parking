package com.statementlabs.parking_api.infrastructure.repository;

import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaParkingSpotRepository extends JpaRepository<ParkingSpotEntity, Long> {

    List<ParkingSpotEntity> findByStatus(SpotStatus status);

    Optional<ParkingSpotEntity> findFirstByStatus(SpotStatus status);
}