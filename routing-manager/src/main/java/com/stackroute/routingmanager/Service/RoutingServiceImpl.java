package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Vehicle;
import com.stackroute.routingmanager.Repository.RoutingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutingServiceImpl implements RoutingService {

    private Vehicle vehicle = new Vehicle(1,100);

    /*@Autowired
    public RoutingServiceImpl(Vehicle vehicle){
        this.vehicle = vehicle;

    }
*/
    @Override
    public String addNode(Node node) {

        vehicle.addNode(node);
        return "added ";
    }
}
