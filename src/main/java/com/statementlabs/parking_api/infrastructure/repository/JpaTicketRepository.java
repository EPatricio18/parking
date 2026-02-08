package com.statementlabs.parking_api.infrastructure.repository;

import com.statementlabs.parking_api.domain.TicketStatus;
import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {
    Optional<TicketEntity> findByPlateAndStatus(String plate, TicketStatus status);
    List<TicketEntity> findAllByStatus(TicketStatus status);
}