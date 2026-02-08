package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
import java.util.List;

public class GetTicketHistoryUseCase {
    private final TicketRepository ticketRepository;

    public GetTicketHistoryUseCase(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> execute(TicketStatus status) {
        if (status == null) return ticketRepository.findAll();
        return ticketRepository.findAllByStatus(status);
    }
}