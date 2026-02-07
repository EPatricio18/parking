package com.statementlabs.parking_api.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ParkingSpotEntity {

    @Id
    private Integer id;

    private String status;

    public ParkingSpotEntity() {}

    public ParkingSpotEntity(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() { return id; }
    public String getStatus() { return status; }

    public void setId(Integer id) { this.id = id; }
    public void setStatus(String status) { this.status = status; }
}
