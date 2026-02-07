package com.statementlabs.parking_api.domain;

public class ParkingSpot {

    private final int id;
    private SpotStatus status;

    public ParkingSpot(int id) {
        this.id = id;
        this.status = SpotStatus.FREE;
    }

    public int getId() {
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
            throw new IllegalStateException("Spot already occupied");
        }
        this.status = SpotStatus.OCCUPIED;
    }

    public void release() {
        if (status == SpotStatus.FREE) {
            throw new IllegalStateException("Spot already free");
        }
        this.status = SpotStatus.FREE;
    }
}
