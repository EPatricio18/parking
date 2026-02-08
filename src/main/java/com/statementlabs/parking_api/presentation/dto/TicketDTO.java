package com.statementlabs.parking_api.presentation.dto;

import com.statementlabs.parking_api.domain.TicketStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketDTO {

    private final Long id;
    private final String plate;
    private final Long parkingSpotId;
    private final LocalDateTime entryTime;
    private final LocalDateTime exitTime;
    private final TicketStatus status;
    private final BigDecimal amount;

    public TicketDTO(Long id,
                     String plate,
                     Long parkingSpotId,
                     LocalDateTime entryTime,
                     LocalDateTime exitTime,
                     TicketStatus status,
                     BigDecimal amount) {
        this.id = id;
        this.plate = plate;
        this.parkingSpotId = parkingSpotId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.status = status;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public Long getParkingSpotId() {
        return parkingSpotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
