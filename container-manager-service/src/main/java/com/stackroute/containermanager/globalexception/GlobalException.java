package com.stackroute.containermanager.globalexception;

import com.stackroute.containermanager.exception.OrderAlreadyExists;
import com.stackroute.containermanager.exception.OrderNotFound;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Order already exists")
    @ExceptionHandler(OrderAlreadyExists.class)
    public void handleOrderAlreadyExists(OrderAlreadyExists or1)
    {

    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Invalid Order")
    @ExceptionHandler(OrderNotFound.class)
    public void handleOrderNotFound(OrderNotFound or2)
    {

    }
}
