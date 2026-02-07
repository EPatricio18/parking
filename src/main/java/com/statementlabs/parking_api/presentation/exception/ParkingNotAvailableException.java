package presentation.exception;

public class ParkingNotAvailableException extends RuntimeException {
    public ParkingNotAvailableException(String message) {
        super(message);
    }
}