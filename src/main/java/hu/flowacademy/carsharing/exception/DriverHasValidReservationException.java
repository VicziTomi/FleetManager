package hu.flowacademy.carsharing.exception;

public class DriverHasValidReservationException extends RuntimeException {
    public DriverHasValidReservationException(String id) {
        super("Valid reservation(s) for user: " + id);
    }
}
