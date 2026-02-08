package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TariffCalculator;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
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
        Ticket ticket = ticketRepository.findOpenByPlate(plate)
                .orElseThrow(() -> new RuntimeException("Ticket aberto não encontrado para a placa: " + plate));

        ticket.close(LocalDateTime.now(), calculator);

        ticketRepository.save(ticket);
        
        spotRepository.save(ticket.getSpot());

        return ticket;
    }
}