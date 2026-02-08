package com.statementlabs.parking_api.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_spot")
public class ParkingSpotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identification; 

    private String status;

    public ParkingSpotEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}