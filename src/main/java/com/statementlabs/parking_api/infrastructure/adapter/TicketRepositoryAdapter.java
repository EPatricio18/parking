package com.statementlabs.parking_api.infrastructure.adapter;

import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
import com.statementlabs.parking_api.infrastructure.repository.JpaTicketRepository;
import com.statementlabs.parking_api.infrastructure.mapper.TicketMapper;
import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TicketRepositoryAdapter implements TicketRepository {

    private final JpaTicketRepository jpaRepository;
    private final TicketMapper mapper;

    public TicketRepositoryAdapter(JpaTicketRepository jpaRepository, TicketMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity entity = TicketMapper.toEntity(ticket);
        TicketEntity savedEntity = jpaRepository.save(entity);
        return TicketMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Ticket> findOpenByPlate(String plate) {
        return jpaRepository.findByPlateAndStatus(plate, TicketStatus.OPEN.name())
                .map(TicketMapper::toDomain);
    }

    @Override
    public List<Ticket> findAll() {
        return jpaRepository.findAll().stream()
                .map(TicketMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ticket> findAllByStatus(TicketStatus status) {
        return jpaRepository.findAllByStatus(status).stream()
                .map(TicketMapper::toDomain)
                .collect(Collectors.toList());
    }
}