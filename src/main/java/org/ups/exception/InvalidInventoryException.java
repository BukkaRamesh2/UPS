package org.ups.exception;

public class InvalidInventoryException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidInventoryException(String message) {
        super(message);
    }
}