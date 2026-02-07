package com.statementlabs.parking_api.infrastructure.persistence.adapter;

import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.*;
import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;
import com.statementlabs.parking_api.infrastructure.persistence.repository.JpaTicketRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketRepositoryAdapter implements TicketRepository {

    private final JpaTicketRepository repository;

    public TicketRepositoryAdapter(JpaTicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Ticket ticket) {

        TicketEntity entity = new TicketEntity();

        entity.setPlate(ticket.getPlate());
        entity.setSpotId(ticket.getSpotId());
        entity.setEntryTime(ticket.getEntryTime());
        entity.setExitTime(ticket.getExitTime());
        entity.setAmount(ticket.getAmount());
        entity.setStatus(ticket.getStatus().name());

        repository.save(entity);
    }

    @Override
    public Optional<Ticket> findOpenByPlate(String plate) {

        return repository
                .findFirstByPlateAndStatus(plate, "OPEN")
                .map(e -> new Ticket(
                        e.getPlate(),
                        e.getSpotId(),
                        e.getEntryTime()
                ));
    }
}