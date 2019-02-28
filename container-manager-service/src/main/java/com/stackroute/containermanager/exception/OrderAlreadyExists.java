package com.stackroute.containermanager.exception;

public class OrderAlreadyExists extends Exception
{
    private String message1;

    public OrderAlreadyExists(String message1)
    {
        super(message1);
        this.message1 = message1;
    }

    public OrderAlreadyExists()
    {
        super();
    }
}
