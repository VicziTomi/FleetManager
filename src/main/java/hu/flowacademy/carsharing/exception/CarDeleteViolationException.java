package hu.flowacademy.carsharing.exception;

import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLException;

public class CarDeleteViolationException extends ConstraintViolationException {

    private String constraintName;

    public CarDeleteViolationException(String message, SQLException root, String constraintName, String constraintName1) {
        super(message, root, constraintName);
        this.constraintName = "Delete forbidden!!!";
    }
}
