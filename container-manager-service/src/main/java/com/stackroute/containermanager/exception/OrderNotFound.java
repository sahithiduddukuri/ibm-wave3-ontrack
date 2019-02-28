package com.stackroute.containermanager.exception;

public class OrderNotFound extends Exception
{
    private String message2;

    public OrderNotFound(String message2)
    {
        super(message2);
        this.message2 = message2;
    }

    public OrderNotFound()
    {
        super();
    }
}
