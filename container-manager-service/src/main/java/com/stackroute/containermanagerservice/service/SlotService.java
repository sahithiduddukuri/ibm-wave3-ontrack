package com.stackroute.containermanagerservice.service;

import com.stackroute.containermanagerservice.domain.Order;
import com.stackroute.containermanagerservice.domain.SlotCheck;
import com.stackroute.containermanagerservice.exception.InvalidOrder;
import com.stackroute.containermanagerservice.exception.OrderAlreadyExists;

public interface SlotService
{
    SlotCheck saveSlots(Order order) throws OrderAlreadyExists;
    SlotCheck getSlots(Order order) throws InvalidOrder;
}
