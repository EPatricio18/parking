package com.statementlabs.parking_api.domain;

import java.time.LocalDateTime;

public class Ticket {

    private final String plate;
    private final int spotId;
    private final LocalDateTime entryTime;

    private LocalDateTime exitTime;
    private Integer amount;
    private TicketStatus status;

    public Ticket(String plate, int spotId) {
        this.plate = plate;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.OPEN;
    }

    public void close(LocalDateTime exitTime, TariffCalculator calculator) {

        if (status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket already closed");
        }

        this.exitTime = exitTime;
        this.amount = calculator.calculate(entryTime, exitTime);
        this.status = TicketStatus.CLOSED;
    }

    public boolean isOpen() {
        return status == TicketStatus.OPEN;
    }

    public String getPlate() {
        return plate;
    }

    public int getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Integer getAmount() {
        return amount;
    }

    public TicketStatus getStatus() {
        return status;
    }
}