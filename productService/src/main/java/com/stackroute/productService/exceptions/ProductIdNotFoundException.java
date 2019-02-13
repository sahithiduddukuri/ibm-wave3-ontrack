package com.stackroute.productService.exceptions;

public class ProductIdNotFoundException extends Exception{

    private String message;

    public ProductIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public ProductIdNotFoundException() {

    }
}
