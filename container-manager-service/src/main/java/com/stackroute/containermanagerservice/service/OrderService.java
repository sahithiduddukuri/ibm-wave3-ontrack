package com.stackroute.containermanagerservice.service;

import com.stackroute.containermanagerservice.domain.Order;
import com.stackroute.containermanagerservice.exception.OrderAlreadyExists;
import com.stackroute.containermanagerservice.exception.InvalidOrder;

import java.util.List;

public interface OrderService
{
    Order saveContainer(Order order) throws OrderAlreadyExists;
    boolean deleteContainer(int orderid) throws InvalidOrder;
    Order updateContainer(int orderId, int productId, int productWeight, int productLength, int productWidth, int productBreadth, boolean isFragile, String deliveryLocation, String orderDate, String orderTime) throws InvalidOrder;
    List<Order> getAllContainers() throws Exception;
    //public Date findAvailableContainer(String date) throws ParseException;
}
