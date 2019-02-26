package com.stackroute.containermanagerservice.globalexception;

import com.stackroute.containermanagerservice.exception.ContainerAlreadyFull;
import com.stackroute.containermanagerservice.exception.ContainerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Container already full")
    @ExceptionHandler(ContainerAlreadyFull.class)
    public void handleContainerAlreadyFullException(ContainerAlreadyFull ce1)
    {

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Container not found")
    @ExceptionHandler(ContainerNotFound.class)
    public void handleContainerNotFound(ContainerNotFound ce2)
    {

    }
}
