package com.parking_api.infrastructure.persistence.jpa;

import com.parking_api.domain.SpotStatus;
import com.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaParkingSpotRepository extends JpaRepository<ParkingSpotEntity, Long> {

    List<ParkingSpotEntity> findByStatus(SpotStatus status);

    Optional<ParkingSpotEntity> findFirstByStatus(SpotStatus status);
}