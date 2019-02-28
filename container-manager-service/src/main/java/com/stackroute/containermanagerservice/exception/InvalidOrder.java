package com.stackroute.containermanagerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not any conatiner")
public class InvalidOrder extends Exception
{

}
