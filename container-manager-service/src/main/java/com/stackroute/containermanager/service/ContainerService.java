package com.stackroute.containermanager.service;

import com.stackroute.containermanager.domain.Order;
import com.stackroute.containermanager.domain.Product;
import com.stackroute.containermanager.domain.SelectedSlot;
import com.stackroute.containermanager.domain.SlotEvaluation;
import com.stackroute.containermanager.exception.OrderAlreadyExists;
import com.stackroute.containermanager.exception.OrderNotFound;

import java.time.LocalDate;
import java.util.List;

public interface ContainerService
{
    public SlotEvaluation saveOrderAndGetSlots(Order order) throws OrderAlreadyExists;
    public SlotEvaluation saveSelecteSlots(SelectedSlot selectedSlot) throws OrderNotFound, OrderAlreadyExists;
    public SlotEvaluation getSlotByDate(String date) throws OrderNotFound;

}
