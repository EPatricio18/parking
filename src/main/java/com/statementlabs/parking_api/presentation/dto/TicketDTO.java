package presentation.dto;

import domain.TicketStatus;
import java.time.LocalDateTime;

public record TicketDTO(
        Long id,
        String plate,
        Long parkingSpotId,
        LocalDateTime checkInTime,
        LocalDateTime checkOutTime,
        TicketStatus status,
        double amount
) {}