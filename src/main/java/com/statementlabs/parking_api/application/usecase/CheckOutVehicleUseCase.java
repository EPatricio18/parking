package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.TariffCalculator;
import com.statementlabs.parking_api.domain.Ticket;

import java.time.LocalDateTime;

public class CheckOutVehicleUseCase {

    private final TicketRepository ticketRepository;
    private final ParkingSpotRepository spotRepository;
    private final TariffCalculator calculator;

    public CheckOutVehicleUseCase(
            TicketRepository ticketRepository,
            ParkingSpotRepository spotRepository,
            TariffCalculator calculator
    ) {
        this.ticketRepository = ticketRepository;
        this.spotRepository = spotRepository;
        this.calculator = calculator;
    }

    public Ticket execute(String plate) {

        Ticket ticket = ticketRepository
                .findOpenByPlate(plate)
                .orElseThrow(() -> new RuntimeException("Open ticket not found"));

        ParkingSpot spot = spotRepository
                .findById(ticket.getSpotId())
                .orElseThrow(() -> new RuntimeException("Spot not found"));

        ticket.close(LocalDateTime.now(), calculator);

        spot.release();

        ticketRepository.save(ticket);
        spotRepository.save(spot);

        return ticket;
    }
}
