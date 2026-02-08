package com.statementlabs.parking_api.infrastructure.repository;

import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JpaParkingSpotRepository extends JpaRepository<ParkingSpotEntity, Long> {
    Optional<ParkingSpotEntity> findFirstByStatus(String status);
    List<ParkingSpotEntity> findAllByStatus(String status);

    @Modifying
    @Transactional
    @Query("UPDATE ParkingSpotEntity p SET p.status = :status WHERE p.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);
}