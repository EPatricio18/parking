package com.parking_api.presentation.mapper;

import com.parking_api.domain.Ticket;
import com.parking_api.presentation.dto.TicketDTO;

public class TicketMapper {

    public static TicketDTO toDTO(Ticket ticket) {
        return new TicketDTO(
            ticket.getId(),         
            ticket.getPlate(),
            ticket.getSpotId(),
            ticket.getEntryTime(),
            ticket.getExitTime(),
            ticket.getStatus(),
            ticket.getAmount()
        );
    }
}
