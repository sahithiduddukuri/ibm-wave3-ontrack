package com.stackroute.containermanagerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Order already full")
public class OrderAlreadyExists extends Exception
{

}
