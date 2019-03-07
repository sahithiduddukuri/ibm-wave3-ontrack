package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.*;
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

        String date= order.getOrderDate();
        int noofOrder;

        if (routingRepository.existsById(order.getOrderDate())){

            System.out.println("inside If");
            System.out.println("inside the if ");
            Optional<SaveOrder> order1 = routingRepository.findById(order.getOrderDate());

            noofOrder = order1.get().getNoOfOrders()+1;
            List<Slot> slots = order1.get().getSlots();
            System.out.println("get slots+++++===="+slots);
            List<Node> nodeList;
            if(slots.isEmpty()) {
                System.out.println("in else of slot check***********");
                Slot slot1 = new Slot();
                slot1.setSlotType(order.getSlotType());
                nodeList = new ArrayList<>();
                Node node1 = new Node();
                node1.setNodeId(order.getOrderId());
                node1.setNode_X(order.getX());
                node1.setNode_Y(order.getY());
                node1.setDemand(order.getDemand());
                nodeList.add(node1);
                slot1.setNodeList(nodeList);

            }
            else {
                for (Slot slot : slots) {
                    if (slot.getSlotType().equals(order.getSlotType())) {
                        System.out.println("inside slot for check type@@@@@@#############@@@@@");
                        nodeList = slot.getNodeList();
                        Node node1 = new Node();
                        node1.setNodeId(order.getOrderId());
                        node1.setNode_X(order.getX());
                        node1.setNode_Y(order.getY());
                        node1.setDemand(order.getDemand());
                        nodeList.add(node1);
                        slot.setNodeList(nodeList);
                        slot.setSlotType(order.getSlotType());

                    } else {
                        System.out.println("in else of slot check***********");
                        Slot slot1 = new Slot();
                        slot1.setSlotType(order.getSlotType());
                        nodeList = new ArrayList<>();
                        Node node1 = new Node();
                        node1.setNodeId(order.getOrderId());
                        node1.setNode_X(order.getX());
                        node1.setNode_Y(order.getY());
                        node1.setDemand(order.getDemand());
                        nodeList.add(node1);
                        slot1.setNodeList(nodeList);
//                    slot.setSlotType(order.getSlotType());
                    }

                }
            }


            order1.get().setSlots(slots);
            order1.get().setNoOfOrders(noofOrder);
            routingRepository.save(order1.get());
        }else{
            System.out.println("inside else");
            SaveOrder saveOrder = new SaveOrder();
            noofOrder=2;
            saveOrder.setNoOfOrders(noofOrder);
            saveOrder.setOrderDate(order.getOrderDate());
            saveOrder.setOrderId(order.getOrderId());
            saveOrder.setOrderLoc(order.getOrderLoc());
            saveOrder.setVehicleId(order.getVehicleId());
            List<Slot> slotList = new ArrayList<>();
            List<Node> nodeList = new ArrayList<>();
            Node node1= new Node();
            node1.setNode_X(order.getX());
            node1.setNode_Y(order.getY());
            node1.setDemand(order.getDemand());
            node1.setNodeId(order.getOrderId());
            nodeList.add(node1);
            Slot slot = new Slot(order.getSlotType(),nodeList);
            slotList.add(slot);

            saveOrder.setSlots(slotList);
            routingRepository.save(saveOrder);
        }

       /*if(routingRepository.findAll().isEmpty()){
           Optional<SaveOrder> order1 =
       }*/

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
