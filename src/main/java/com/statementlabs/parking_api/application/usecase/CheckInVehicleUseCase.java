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
        ticketRepository.findOpenByPlate(plate).ifPresent(t -> {
            throw new RuntimeException("Veículo com placa " + plate + " já está no estacionamento!");
        });
    
        ParkingSpot spot = spotRepository
                .findFirstFree()
                .orElseThrow(() -> new RuntimeException("Não existem vagas livres disponíveis"));
    
        spot.occupy();
        
        spotRepository.save(spot);
    
        Ticket ticket = new Ticket(plate, spot); 
    
        return ticketRepository.save(ticket);
    }
}