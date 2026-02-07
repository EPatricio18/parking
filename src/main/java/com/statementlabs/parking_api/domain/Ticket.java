package com.statementlabs.parking_api.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private final String plate;
    private final Long spotId;
    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;
    private BigDecimal amount;
    private TicketStatus status;

    public Ticket(String plate, Long spotId) {
        this.plate = plate;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.OPEN;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void close(LocalDateTime exitTime, TariffCalculator calculator) {
        if (status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket already closed");
        }
        this.exitTime = exitTime;
        this.amount = calculator.calculate(entryTime, exitTime);
        this.status = TicketStatus.CLOSED;
    }

    public boolean isOpen() { return status == TicketStatus.OPEN; }

    public String getPlate() { return plate; }
    public Long getSpotId() { return spotId; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public BigDecimal getAmount() { return amount; }
    public TicketStatus getStatus() { return status; }
}
