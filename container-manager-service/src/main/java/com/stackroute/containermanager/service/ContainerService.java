package com.stackroute.containermanager.service;

import com.stackroute.containermanager.domain.Order;
import com.stackroute.containermanager.domain.SlotEvaluation;
import com.stackroute.containermanager.exception.OrderAlreadyExists;

public interface ContainerService
{
    public SlotEvaluation saveOrderAndGetSlots(Order order) throws OrderAlreadyExists;
}
