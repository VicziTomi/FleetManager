package hu.flowacademy.carsharing.exception;

public class CarExpirationException extends RuntimeException {
    public CarExpirationException() {
        super("Selected car expires befor reservation start...");
    }
}
