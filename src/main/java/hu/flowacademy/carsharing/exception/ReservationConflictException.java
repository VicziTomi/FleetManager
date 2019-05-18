package hu.flowacademy.carsharing.exception;

public class ReservationConflictException extends RuntimeException {

    public ReservationConflictException() {
        super("Desired period in conflict with other reservation!");
    }
}
