package hu.flowacademy.carsharing.exception;

public class CarHasValidReservationsException extends RuntimeException {
    public CarHasValidReservationsException() {
        super("Car can not be deleted due to valid reservation(s)");
    }
}
