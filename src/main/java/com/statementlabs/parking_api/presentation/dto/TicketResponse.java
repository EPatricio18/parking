package com.statementlabs.parking_api.presentation.dto;

import java.time.LocalDateTime;

public class TicketResponse {
    private Long id;
    private String licensePlate;
    private int spotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double price;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public int getSpotNumber() { return spotNumber; }
    public void setSpotNumber(int spotNumber) { this.spotNumber = spotNumber; }

    public LocalDateTime getEntryTime() { return entryTime; }
    public void setEntryTime(LocalDateTime entryTime) { this.entryTime = entryTime; }

    public LocalDateTime getExitTime() { return exitTime; }
    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}