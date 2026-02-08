package com.statementlabs.parking_api.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String plate;

    @Column(name = "spot_id", nullable = false)
    private Long spotId;

    @Column(name = "entry_time", nullable = false)
    private LocalDateTime entryTime;

    @Column(name = "exit_time", nullable = true) 
    private LocalDateTime exitTime;

    @Column(nullable = true)
    private BigDecimal amount;

    @Column(nullable = false)
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
    public void setId(Long id) { this.id = id; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public Long getSpotId() { return spotId; }
    public void setSpotId(Long spotId) { this.spotId = spotId; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public void setEntryTime(LocalDateTime entryTime) { this.entryTime = entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}