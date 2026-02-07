package com.statementlabs.parking_api.presentation.exception;

public class ParkingNotAvailableException extends RuntimeException {
    public ParkingNotAvailableException(String message) {
        super(message);
    }
}