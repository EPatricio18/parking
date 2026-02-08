package com.statementlabs.parking_api.application.port;

import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Optional<Ticket> findOpenByPlate(String plate);
    List<Ticket> findAll();
    List<Ticket> findAllByStatus(TicketStatus status);
}