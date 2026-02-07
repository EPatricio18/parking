package presentation.controller;

import application.usecase.CheckInVehicleUseCase;
import application.usecase.CheckOutVehicleUseCase;
import presentation.dto.CheckInRequest;
import presentation.dto.CheckOutRequest;
import presentation.dto.TicketDTO;
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
                ticket.getParkingSpotId(),
                ticket.getCheckInTime(),
                ticket.getCheckOutTime(),
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
                ticket.getParkingSpotId(),
                ticket.getCheckInTime(),
                ticket.getCheckOutTime(),
                ticket.getStatus(),
                ticket.getAmount()
        );
    }
}