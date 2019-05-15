package hu.flowacademy.carsharing.exception;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(String id) {
        super("Reservation not found by: " + id);
    }
}
