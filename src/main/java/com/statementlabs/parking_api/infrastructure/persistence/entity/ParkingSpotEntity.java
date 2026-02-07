package com.statementlabs.parking_api.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ParkingSpotEntity {

    @Id
    private Long id;

    private String status;

    public ParkingSpotEntity() {}

    public ParkingSpotEntity(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setStatus(String status) { this.status = status; }
}
