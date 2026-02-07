package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.domain.TariffCalculator;
import com.statementlabs.parking_api.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckOutVehicleUseCaseTest {

    private TicketRepository ticketRepo;
    private ParkingSpotRepository spotRepo;
    private TariffCalculator calculator;
    private CheckOutVehicleUseCase useCase;

    @BeforeEach
    void setup() {
        ticketRepo = mock(TicketRepository.class);
        spotRepo = mock(ParkingSpotRepository.class);
        calculator = new TariffCalculator();
        useCase = new CheckOutVehicleUseCase(ticketRepo, spotRepo, calculator);
    }

    @Test
    void execute_successfulCheckOut() {
        Ticket ticket = new Ticket("ABC-123", 1L);
        ParkingSpot spot = new ParkingSpot(1L, SpotStatus.OCCUPIED);

        when(ticketRepo.findOpenByPlate("ABC-123")).thenReturn(Optional.of(ticket));
        when(spotRepo.findById(1L)).thenReturn(Optional.of(spot));

        Ticket result = useCase.execute("ABC-123");

        assertFalse(result.isOpen());
        assertFalse(spot.isFree());
        assertNotNull(result.getAmount());
        verify(ticketRepo).save(result);
        verify(spotRepo).save(spot);
    }

    @Test
    void execute_ticketNotFound_throwsException() {
        when(ticketRepo.findOpenByPlate("XYZ-999")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> useCase.execute("XYZ-999"));
    }

    @Test
    void execute_spotNotFound_throwsException() {
        Ticket ticket = new Ticket("ABC-123", 1L);
        when(ticketRepo.findOpenByPlate("ABC-123")).thenReturn(Optional.of(ticket));
        when(spotRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> useCase.execute("ABC-123"));
    }
}