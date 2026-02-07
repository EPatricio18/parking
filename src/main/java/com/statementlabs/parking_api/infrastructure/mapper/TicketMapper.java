package com.statementlabs.parking_api.infrastructure.mapper;

import com.statementlabs.parking_api.domain.TariffCalculator;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;

import java.time.LocalDateTime;

public class TicketMapper {

    public static Ticket toDomain(TicketEntity entity, TariffCalculator calculator) {
        if (entity == null) return null;

        Ticket ticket = new Ticket(entity.getPlate(), entity.getSpotId());
        ticket.setId(entity.getId());

        if (entity.getExitTime() != null) {
            ticket.close(entity.getExitTime(), calculator);
        }

        return ticket;
    }

    public static TicketEntity toEntity(Ticket ticket) {
        if (ticket == null) return null;

        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId());
        entity.setPlate(ticket.getPlate());
        entity.setSpotId(ticket.getSpotId());
        entity.setEntryTime(ticket.getEntryTime());
        entity.setExitTime(ticket.getExitTime());
        entity.setAmount(ticket.getAmount());
        entity.setStatus(ticket.getStatus().name());

        return entity;
    }
}