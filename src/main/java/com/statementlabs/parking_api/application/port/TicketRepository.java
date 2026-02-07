package com.statementlabs.parking_api.application.port;

import com.statementlabs.parking_api.domain.Ticket;

import java.util.Optional;

public interface TicketRepository {

    void save(Ticket ticket);

    Optional<Ticket> findOpenByPlate(String plate);
}
