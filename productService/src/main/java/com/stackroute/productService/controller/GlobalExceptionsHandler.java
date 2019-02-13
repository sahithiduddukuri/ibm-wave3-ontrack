package com.stackroute.productService.controller;


import com.stackroute.productService.exceptions.ProductAlreadyExistsException;
import com.stackroute.productService.exceptions.ProductAlreadyUpdatedExcetion;
import com.stackroute.productService.exceptions.ProductIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionsHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Product already exist")
    @ExceptionHandler(ProductAlreadyExistsException.class)
    public void handleTrackAlreadyExistException(ProductAlreadyExistsException e){
        System.out.println("Product already exist");
    }
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Product not found")
    @ExceptionHandler(ProductIdNotFoundException.class)
    public void handleTrackNotFoundException(ProductIdNotFoundException e){
        System.out.println("Product not found");
    }
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Product id not found")
    @ExceptionHandler(ProductAlreadyUpdatedExcetion.class)
    public void handleTrackAlreadyUdatedException(ProductAlreadyUpdatedExcetion e){
        System.out.println("Product not found");
    }
}
