package com.parking_api.presentation.mapper;

import com.parking_api.domain.model.Ticket;
import com.parking_api.presentation.dto.TicketResponse;

public class TicketMapper {

    public static TicketResponse toResponse(Ticket ticket) {
        if (ticket == null) return null;

        return new TicketResponse(
            ticket.getId(),
            ticket.getPlate(),
            ticket.getSpotId(),
            ticket.getEntryTime(),
            ticket.getExitTime(),
            ticket.getAmount(),
            ticket.getStatus().toString()
        );
    }
}