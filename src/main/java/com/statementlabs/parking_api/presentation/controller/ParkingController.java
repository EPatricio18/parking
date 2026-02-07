// ParkingController.java
package presentation.controller;

import application.usecase.CheckInVehicleUseCase;
import application.usecase.CheckOutVehicleUseCase;
import domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import presentation.dto.CheckInRequest;
import presentation.dto.CheckOutRequest;
import presentation.dto.TicketResponse;
import presentation.mapper.TicketMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    private final CheckInVehicleUseCase checkInUseCase;
    private final CheckOutVehicleUseCase checkOutUseCase;

    public ParkingController(CheckInVehicleUseCase checkInUseCase, CheckOutVehicleUseCase checkOutUseCase) {
        this.checkInUseCase = checkInUseCase;
        this.checkOutUseCase = checkOutUseCase;
    }

    @PostMapping("/checkin")
    public ResponseEntity<TicketResponse> checkIn(@Valid @RequestBody CheckInRequest request) {
        Ticket ticket = checkInUseCase.execute(request.getLicensePlate());
        return ResponseEntity.status(HttpStatus.CREATED).body(TicketMapper.toResponse(ticket));
    }

    @PostMapping("/checkout")
    public ResponseEntity<TicketResponse> checkOut(@Valid @RequestBody CheckOutRequest request) {
        Ticket ticket = checkOutUseCase.execute(request.getTicketId());
        return ResponseEntity.ok(TicketMapper.toResponse(ticket));
    }
}