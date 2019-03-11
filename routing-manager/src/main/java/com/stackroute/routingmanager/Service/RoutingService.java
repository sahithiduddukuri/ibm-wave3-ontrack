package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Domain.Vehicle;

import java.util.List;

public interface RoutingService {

    public String[] locationlatlng(Order order);

    public String saveOrder(Order order);

    public List<Vehicle> optimizedRoute(String slotType, String date);

}
