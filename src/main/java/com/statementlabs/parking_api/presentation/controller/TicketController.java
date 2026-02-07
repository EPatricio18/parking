package com.parking_api.presentation.controller;

import com.parking_api.application.usecase.CheckInVehicleUseCase;
import com.parking_api.application.usecase.CheckOutVehicleUseCase;
import com.parking_api.presentation.dto.CheckInRequest;
import com.parking_api.presentation.dto.CheckOutRequest;
import com.parking_api.presentation.dto.TicketDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final CheckInVehicleUseCase checkInUseCase;
    private final CheckOutVehicleUseCase checkOutUseCase;

    public TicketController(CheckInVehicleUseCase checkInUseCase,
                            CheckOutVehicleUseCase checkOutUseCase) {
        this.checkInUseCase = checkInUseCase;
        this.checkOutUseCase = checkOutUseCase;
    }

    @PostMapping("/checkin")
    public TicketDTO checkIn(@RequestBody CheckInRequest request) {
        var ticket = checkInUseCase.execute(request.plate());
        return new TicketDTO(
                ticket.getId(),            
                ticket.getPlate(),
                ticket.getSpotId(),
                ticket.getEntryTime(),
                ticket.getExitTime(),
                ticket.getStatus(),
                ticket.getAmount()         
        );
    }

    @PostMapping("/checkout")
    public TicketDTO checkOut(@RequestBody CheckOutRequest request) {
        var ticket = checkOutUseCase.execute(request.plateOrTicketId());
        return new TicketDTO(
                ticket.getId(),
                ticket.getPlate(),
                ticket.getSpotId(),
                ticket.getEntryTime(),
                ticket.getExitTime(),
                ticket.getStatus(),
                ticket.getAmount()
        );
    }
}
