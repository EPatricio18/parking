package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CheckInVehicleUseCaseTest {

    private ParkingSpotRepository spotRepo;
    private TicketRepository ticketRepo;
    private CheckInVehicleUseCase useCase;

    @BeforeEach
    void setup() {
        spotRepo = mock(ParkingSpotRepository.class);
        ticketRepo = mock(TicketRepository.class);
        useCase = new CheckInVehicleUseCase(spotRepo, ticketRepo);
    }

    @Test
    void execute_successfulCheckIn() {
        ParkingSpot spot = new ParkingSpot(1L, SpotStatus.FREE);
        when(spotRepo.findFirstFree()).thenReturn(Optional.of(spot));

        Ticket ticket = useCase.execute("ABC-123");

        assertEquals("ABC-123", ticket.getPlate());
        assertEquals(1L, ticket.getSpotId());
        assertFalse(spot.isFree());

        verify(spotRepo).save(spot);
        verify(ticketRepo).save(ticket);
    }

    @Test
    void execute_noFreeSpot_throwsException() {
        when(spotRepo.findFirstFree()).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> useCase.execute("XYZ-999"));
    }
}