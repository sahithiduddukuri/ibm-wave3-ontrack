package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Order;
import com.stackroute.routingmanager.Domain.SaveOrder;
import com.stackroute.routingmanager.Domain.Vehicle;
import com.stackroute.routingmanager.Repository.RoutingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();

        LocalDate date= order.getDate();
        int noofOrder;
//        if(routingRepository.existsById(date))
//        {
//            Optional<SaveOrder> order1= routingRepository.findById(order.getDate());
//            noofOrder =  order1.get().getNoOfOrders()+1;
//            order1.get().setNoOfOrders(noofOrder);
//        }
//        else {
//            noofOrder=1;
//        }
        if (routingRepository.existsById(order.getDate())){
            System.out.println("inside If");
            System.out.println("inside the if ");
            Optional<SaveOrder> order1 = routingRepository.findById(order.getDate());
            noofOrder = order1.get().getNoOfOrders()+1;
            List<Node> nodeList = order1.get().getNodes();
            Node node1= new Node();
            node1.setNodeId(order.getOrderId());
            node1.setNode_X(order.getX());
            node1.setNode_Y(order.getY());
            node1.setDemand(order.getDemand());
            nodeList.add(node1);
            order1.get().setNodes(nodeList);
            order1.get().setNoOfOrders(noofOrder);
            routingRepository.save(order1.get());
        }else{
            System.out.println("inside else");
            SaveOrder saveOrder = new SaveOrder();
            noofOrder=2;
            saveOrder.setNoOfOrders(noofOrder);
            saveOrder.setDate(order.getDate());
            saveOrder.setOrderId(order.getOrderId());
            saveOrder.setOrderLoc(order.getOrderLoc());
            saveOrder.setVehicleId(order.getVehicleId());
            List<Node> nodeList = new ArrayList<>();
            Node node1= new Node();
            node1.setNode_X(order.getX());
            node1.setNode_Y(order.getY());
            node1.setDemand(order.getDemand());
            node1.setNodeId(order.getOrderId());
            nodeList.add(node1);
            saveOrder.setNodes(nodeList);
            routingRepository.save(saveOrder);
        }
        optimizedSolution.optimizedCost(noofOrder,order.getX(),order.getY(),order.getDemand());
        //routingRepository.save(order);
        return "order added";
    }

    @Override
    public String optimizedRoute() {
        OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
        //optimizedSolution.optimizedCost();
        return "getResult";
    }


}
