package com.stackroute.productService.exceptions;

public class ProductAlreadyUpdatedExcetion extends Exception{

    private String message;

    public ProductAlreadyUpdatedExcetion(String message) {
        super(message);
        this.message = message;
    }

    public ProductAlreadyUpdatedExcetion() {

    }
}
