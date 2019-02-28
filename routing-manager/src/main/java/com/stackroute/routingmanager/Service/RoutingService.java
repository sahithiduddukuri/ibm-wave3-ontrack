package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;

public interface RoutingService {

    public String saveOrder(Order order);

    public String optimizedRoute();

}
