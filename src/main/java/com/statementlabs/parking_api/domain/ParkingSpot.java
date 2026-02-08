package com.statementlabs.parking_api.domain;

public class ParkingSpot {

    private final Long id; 
    private SpotStatus status;

    public ParkingSpot(Long id, SpotStatus status) {
        this.id = id;
        this.status = status;
    }

    public ParkingSpot(Long id) {
        this.id = id;
        this.status = SpotStatus.FREE;
    }

    public Long getId() {
        return id;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public boolean isFree() {
        return status == SpotStatus.FREE;
    }

    public void occupy() {
        if (status == SpotStatus.OCCUPIED) {
            throw new IllegalStateException("Vaga já ocupada");
        }
        this.status = SpotStatus.OCCUPIED;
    }

    public void release() {
        this.status = SpotStatus.FREE;
    }
}