package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Domain.Vehicle;
import com.stackroute.routingmanager.Repository.RoutingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutingServiceImpl implements RoutingService {

    private Vehicle vehicle = new Vehicle(1,100);

    private RoutingRepository routingRepository;

    @Autowired
    public RoutingServiceImpl(RoutingRepository routingRepository){
        this.routingRepository = routingRepository;
    }

    @Override
    public String saveOrder(Order order) {
        Node node = new Node();
        node.setNodeId(order.getOrderId());
        node.setNode_X(order.getX());
        node.setNode_Y(order.getY());
        node.setDemand(order.getDemand());
        System.out.println("inside save order service");
        vehicle.addNode(node);

        routingRepository.save(order);
            return "order added";
    }

    @Override
    public String optimizedRoute() {
        OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
        optimizedSolution.optimizedCost();
        return "getResult";
//        return null;
    }

   /* @Override
    public String addNode(Node node) {

        vehicle.addNode(node);
        return "added ";
    }*/
}
