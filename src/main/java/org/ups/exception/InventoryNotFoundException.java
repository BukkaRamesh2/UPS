package org.ups.exception;

public class InventoryNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public InventoryNotFoundException(String message) {
        super(message);
    }
}