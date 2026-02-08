package com.statementlabs.parking_api.application.usecase;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
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

        when(ticketRepo.save(any(Ticket.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Ticket ticket = useCase.execute("ABC-123");

        assertEquals(1L, ticket.getSpot().getId());
        assertEquals(TicketStatus.OPEN, ticket.getStatus());
        assertEquals(TicketStatus.OPEN, ticket.getStatus());

        verify(spotRepo).save(spot);
        verify(ticketRepo).save(ticket);
    }

    @Test
    void execute_noFreeSpot_throwsException() {
        when(spotRepo.findFirstFree()).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> useCase.execute("XYZ-999"));
    }
}