package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.Ticket;

public class CheckInVehicleUseCase {

    private final ParkingSpotRepository spotRepository;
    private final TicketRepository ticketRepository;

    public CheckInVehicleUseCase(ParkingSpotRepository spotRepository,
                                 TicketRepository ticketRepository) {
        this.spotRepository = spotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket execute(String plate) {

        ParkingSpot spot = spotRepository
                .findFirstFree()
                .orElseThrow(() -> new RuntimeException("No free spots available"));

        spot.occupy();
        spotRepository.save(spot);

        Ticket ticket = new Ticket(plate, spot.getId());
        ticketRepository.save(ticket);

        return ticket;
    }
}
