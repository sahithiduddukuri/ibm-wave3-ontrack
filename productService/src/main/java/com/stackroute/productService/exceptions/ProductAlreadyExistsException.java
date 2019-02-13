package com.stackroute.productService.exceptions;

public class ProductAlreadyExistsException extends Exception{

    private String message;

    public ProductAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public ProductAlreadyExistsException() {

    }
}
