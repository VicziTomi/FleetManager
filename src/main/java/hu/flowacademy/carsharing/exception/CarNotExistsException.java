package hu.flowacademy.carsharing.exception;


public class CarNotExistsException extends RuntimeException {

    public CarNotExistsException(String id){
        super("Car not found " + id);
    }
}
