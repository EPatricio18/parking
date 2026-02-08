package com.statementlabs.parking_api.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {

    private Long id;
    private final String plate;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private BigDecimal amount;
    private TicketStatus status;

    public Ticket(String plate, ParkingSpot spot) {
        this.plate = plate;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.OPEN;
    }

    public Ticket(Long id, String plate, ParkingSpot spot, LocalDateTime entryTime, 
                  LocalDateTime exitTime, BigDecimal amount, TicketStatus status) {
        this.id = id;
        this.plate = plate;
        this.spot = spot;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.amount = amount;
        this.status = status;
    }

    public void close(LocalDateTime exitTime, TariffCalculator calculator) {
        if (this.status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket já está fechado.");
        }
        this.exitTime = exitTime;
        this.amount = calculator.calculate(this.entryTime, exitTime);
        this.status = TicketStatus.CLOSED;
        
        this.spot.release(); 
    }

    public Long getId() { return id; }
    public String getPlate() { return plate; }
    public ParkingSpot getSpot() { return spot; } // Getter do objeto
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public BigDecimal getAmount() { return amount; }
    public TicketStatus getStatus() { return status; }
    public void setId(Long id) { this.id = id; }
}