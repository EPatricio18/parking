package com.statementlabs.parking_api.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;
    private Long spotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private BigDecimal amount;
    private String status;

    public TicketEntity() {}

    public TicketEntity(String plate, Long spotId, LocalDateTime entryTime,
                        LocalDateTime exitTime, BigDecimal amount, String status) {
        this.plate = plate;
        this.spotId = spotId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getPlate() { return plate; }
    public Long getSpotId() { return spotId; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public BigDecimal getAmount() { return amount; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setPlate(String plate) { this.plate = plate; }
    public void setSpotId(Long spotId) { this.spotId = spotId; }
    public void setEntryTime(LocalDateTime entryTime) { this.entryTime = entryTime; }
    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setStatus(String status) { this.status = status; }
}
