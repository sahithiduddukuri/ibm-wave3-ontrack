package com.stackroute.containermanagerservice.globalexception;

import com.stackroute.containermanagerservice.exception.OrderAlreadyExists;
import com.stackroute.containermanagerservice.exception.InvalidOrder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Order already full")
    @ExceptionHandler(OrderAlreadyExists.class)
    public void handleContainerAlreadyFullException(OrderAlreadyExists ce1)
    {

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Order not found")
    @ExceptionHandler(InvalidOrder.class)
    public void handleContainerNotFound(InvalidOrder ce2)
    {

    }
}
