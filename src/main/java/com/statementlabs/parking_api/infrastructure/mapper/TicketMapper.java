package com.statementlabs.parking_api.infrastructure.mapper;

import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;

public class TicketMapper {

    public static Ticket toDomain(TicketEntity entity) {
        if (entity == null) return null;

        TicketStatus status = entity.getStatus() != null ? 
                              TicketStatus.valueOf(entity.getStatus()) : null;

        return new Ticket(
                entity.getId(),
                entity.getPlate(),
                entity.getSpotId(),
                entity.getEntryTime(),
                entity.getExitTime(),
                entity.getAmount(),
                status
        );
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
        
        if (ticket.getStatus() != null) {
            entity.setStatus(ticket.getStatus().name());
        }

        return entity;
    }
}