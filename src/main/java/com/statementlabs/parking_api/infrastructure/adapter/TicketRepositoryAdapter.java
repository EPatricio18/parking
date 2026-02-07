package com.statementlabs.parking_api.infrastructure.persistence.adapter;

import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.infrastructure.mapper.TicketMapper;
import com.statementlabs.parking_api.infrastructure.persistence.repository.JpaTicketRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketRepositoryAdapter implements TicketRepository {

    private final JpaTicketRepository jpaRepository;

    public TicketRepositoryAdapter(JpaTicketRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Ticket ticket) {
        jpaRepository.save(TicketMapper.toEntity(ticket));
    }

    @Override
    public Optional<Ticket> findOpenByPlate(String plate) {
        return jpaRepository
                .findFirstByPlateAndStatus(plate, "OPEN")
                .map(TicketMapper::toDomain);
    }
}
