package com.statementlabs.parking_api.presentation.mapper;

import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.presentation.dto.TicketDTO;

public class TicketMapper {

    public static TicketDTO toDTO(Ticket ticket) {
        return new TicketDTO(
            ticket.getId(),         
            ticket.getPlate(),
            ticket.getSpot().getId(),
            ticket.getEntryTime(),
            ticket.getExitTime(),
            ticket.getStatus(),
            ticket.getAmount()
        );
    }
}
