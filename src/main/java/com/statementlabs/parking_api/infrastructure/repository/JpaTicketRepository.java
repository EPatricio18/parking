package com.statementlabs.parking_api.infrastructure.persistence.repository;

import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {

    Optional<TicketEntity> findFirstByPlateAndStatus(String plate, String status);
}