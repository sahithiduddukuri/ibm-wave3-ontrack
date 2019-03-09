package com.stackroute.routingmanager.Exceptions;

public class IllegalLocationMatrixException extends Exception {

    private String message;

    public IllegalLocationMatrixException(String message) {
        super(message);
        this.message = message;
    }
}
