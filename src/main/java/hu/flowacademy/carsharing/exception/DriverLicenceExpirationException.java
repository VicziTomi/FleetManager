package hu.flowacademy.carsharing.exception;

public class DriverLicenceExpirationException extends RuntimeException {
    public DriverLicenceExpirationException() {
        super("Can NOT save reservation due to driver licence expiration!");
    }
}
