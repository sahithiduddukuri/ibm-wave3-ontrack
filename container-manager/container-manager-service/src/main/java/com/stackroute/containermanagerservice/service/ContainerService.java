package com.stackroute.containermanagerservice.service;

import com.stackroute.containermanagerservice.domain.Container;
import com.stackroute.containermanagerservice.exception.ContainerAlreadyFull;
import com.stackroute.containermanagerservice.exception.ContainerNotFound;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ContainerService
{
    Container saveContainer(Container container) throws ContainerAlreadyFull;
    boolean deleteContainer(int orderid) throws ContainerNotFound;
    Container updateContainer(int orderId, int productId, int productWeight, int productLength, int productWidth, int productBreadth, boolean isFragile, String deliveryLocation,String orderDate,String orderTime,String containerId,String date,String slotNumber) throws ContainerNotFound;
    List<Container> getAllContainers() throws Exception;
    public Date findAvailableContainer(String date) throws ParseException;
}
