package com.stackroute.containermanagerservice.service;

import com.stackroute.containermanagerservice.domain.Order;
import com.stackroute.containermanagerservice.domain.SlotCheck;
import com.stackroute.containermanagerservice.exception.InvalidOrder;
import com.stackroute.containermanagerservice.exception.OrderAlreadyExists;
import com.stackroute.containermanagerservice.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

public class SlotServiceImpl implements SlotService
{

    private SlotRepository slotRepository;
    private Order order;

    @Autowired
    public SlotServiceImpl(SlotRepository slotRepository)
    {
        this.slotRepository = slotRepository;
    }

    @Override
    public SlotCheck saveSlots(Order order) throws OrderAlreadyExists
    {
        LocalDate userDate= LocalDate.now();
        LocalDate nextDate=userDate.plusDays(1);
        LocalDate nexttonextDate=userDate.plusDays(2);


    }

    @Override
    public SlotCheck getSlots(Order order) throws InvalidOrder
    {
        return null;
    }
}
