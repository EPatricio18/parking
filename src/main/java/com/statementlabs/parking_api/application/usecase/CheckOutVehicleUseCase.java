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

    public CheckOutVehicleUseCase(TicketRepository ticketRepository,
                                  ParkingSpotRepository spotRepository,
                                  TariffCalculator calculator) {
        this.ticketRepository = ticketRepository;
        this.spotRepository = spotRepository;
        this.calculator = calculator;
    }

    public Ticket execute(String plate) {
        Ticket ticket = ticketRepository
                .findOpenByPlate(plate)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado um ticket aberto para a placa: " + plate));

        ParkingSpot spot = spotRepository
                .findById(ticket.getSpotId())
                .orElseThrow(() -> new RuntimeException("Vaga ID " + ticket.getSpotId() + " não encontrada no sistema"));

        ticket.close(LocalDateTime.now(), calculator);

        spot.release();

        spotRepository.save(spot);

        return ticketRepository.save(ticket);
    }
}