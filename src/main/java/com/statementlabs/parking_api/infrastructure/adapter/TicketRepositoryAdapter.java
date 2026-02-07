package com.statementlabs.parking_api.infrastructure.adapter;

import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TariffCalculator;
import com.statementlabs.parking_api.infrastructure.mapper.TicketMapper;
import com.statementlabs.parking_api.infrastructure.repository.JpaTicketRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketRepositoryAdapter implements TicketRepository {

    private final JpaTicketRepository jpaRepository;
    private final TariffCalculator calculator;

    public TicketRepositoryAdapter(JpaTicketRepository jpaRepository,
                               TariffCalculator calculator) {
        this.jpaRepository = jpaRepository;
        this.calculator = calculator;
    }

    @Override
    public void save(Ticket ticket) {
        jpaRepository.save(TicketMapper.toEntity(ticket));
    }

    @Override
    public Optional<Ticket> findOpenByPlate(String plate) {
        return jpaRepository
                .findFirstByPlateAndStatus(plate, "OPEN")
                .map(entity -> TicketMapper.toDomain(entity, calculator));
    }
}
