package hu.flowacademy.carsharing.exception;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(String id) {
        super("Driver not found..." + id);
    }
}
