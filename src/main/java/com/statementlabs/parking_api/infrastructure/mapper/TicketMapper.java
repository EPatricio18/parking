package com.statementlabs.parking_api.infrastructure.mapper;

import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.infrastructure.persistence.entity.TicketEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public static Ticket toDomain(TicketEntity entity) {
        if (entity == null) return null;
    
        TicketStatus domainStatus = (entity.getStatus() != null) 
                ? TicketStatus.valueOf(entity.getStatus()) 
                : null;
    
        ParkingSpot domainSpot = new ParkingSpot(
                entity.getSpotId(), 
                SpotStatus.OCCUPIED 
        );
    
        return new Ticket(
                entity.getId(),
                entity.getPlate(),
                domainSpot, 
                entity.getEntryTime(),
                entity.getExitTime(),
                entity.getAmount(),
                domainStatus
        );
    }

    public static TicketEntity toEntity(Ticket ticket) {
        if (ticket == null) return null;
    
        TicketEntity entity = new TicketEntity();
        entity.setId(ticket.getId());
        entity.setPlate(ticket.getPlate());
        
        if (ticket.getSpot() != null) {
            entity.setSpotId(ticket.getSpot().getId());
        }
        
        entity.setEntryTime(ticket.getEntryTime());
        entity.setExitTime(ticket.getExitTime());
        entity.setAmount(ticket.getAmount());
        
        if (ticket.getStatus() != null) {
            entity.setStatus(ticket.getStatus().name());
        }
    
        return entity;
    }
}