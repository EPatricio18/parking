package com.statementlabs.parking_api.presentation.controller;

import com.statementlabs.parking_api.application.usecase.CheckInVehicleUseCase;
import com.statementlabs.parking_api.application.usecase.CheckOutVehicleUseCase;
import com.statementlabs.parking_api.application.usecase.GetTicketHistoryUseCase;
import com.statementlabs.parking_api.domain.Ticket;
import com.statementlabs.parking_api.domain.TicketStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final CheckInVehicleUseCase checkInUseCase;
    private final CheckOutVehicleUseCase checkOutUseCase;
    private final GetTicketHistoryUseCase historyUseCase;

    public TicketController(CheckInVehicleUseCase checkInUseCase, 
                            CheckOutVehicleUseCase checkOutUseCase, 
                            GetTicketHistoryUseCase historyUseCase) {
        this.checkInUseCase = checkInUseCase;
        this.checkOutUseCase = checkOutUseCase;
        this.historyUseCase = historyUseCase;
    }

    @PostMapping("/check-in/{plate}")
    public ResponseEntity<Ticket> checkIn(@PathVariable String plate) {
        return ResponseEntity.ok(checkInUseCase.execute(plate));
    }

    @PostMapping("/check-out/{plate}")
    public ResponseEntity<Ticket> checkOut(@PathVariable String plate) {
        return ResponseEntity.ok(checkOutUseCase.execute(plate));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Ticket>> getActiveVehicles() {
        return ResponseEntity.ok(historyUseCase.execute(TicketStatus.OPEN));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Ticket>> getFullHistory() {
        return ResponseEntity.ok(historyUseCase.execute(TicketStatus.CLOSED));
    }
}