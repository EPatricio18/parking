package presentation.mapper;

import domain.Ticket;
import presentation.dto.TicketResponse;

public class TicketMapper {

    public static TicketResponse toResponse(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setId(ticket.getId());
        response.setLicensePlate(ticket.getLicensePlate());
        response.setSpotNumber(ticket.getParkingSpot().getNumber());
        response.setEntryTime(ticket.getEntryTime());
        response.setExitTime(ticket.getExitTime());
        response.setPrice(ticket.getPrice());
        return response;
    }
}