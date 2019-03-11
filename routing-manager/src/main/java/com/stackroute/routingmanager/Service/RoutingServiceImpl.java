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
        OptimizedSolutionImpl optimizedSolution = new OptimizedSolutionImpl();
        // String date = order.getOrderDate();
        int noofOrder=0;
//        SaveOrder saveOrder;
        List<Node> nodeList;
        if(routingRepository.existsById(order.getOrderDate()))
        {
            Optional<SaveOrder> saveOrder =  routingRepository.findById(order.getOrderDate());
            saveOrder.get().setOrderDate(order.getOrderDate());
            saveOrder.get().setVehicleId(order.getVehicleId());
            saveOrder.get().setOrderId(order.getOrderId());
            List<Slot> slots = saveOrder.get().getSlots();
            System.out.println("Slots value is"+slots);
            for(int i=0;i<slots.size();i++)
            {
                System.out.println("inside for loop");
                if(slots.get(i).getSlotType().equals(order.getSlotType()))
                {
                    noofOrder = slots.get(i).getNoOfOrders()+1;
                    System.out.println("this type is equal"+slots.get(i).getSlotType());
                    nodeList = slots.get(i).getNodeList();
                    nodeList.add(node);
                    slots.get(i).setNodeList(nodeList);
                    slots.get(i).setNoOfOrders(noofOrder);
                    System.out.println("this is after");
                }
            }
            saveOrder.get().setSlots(slots);
            routingRepository.save(saveOrder.get());
        }
        else{
            System.out.println("inside else first time############################");
            SaveOrder saveOrder= new SaveOrder();
            noofOrder = 2;
//            saveOrder.setNoOfOrders(noofOrder);
            saveOrder.setOrderDate(order.getOrderDate());
            saveOrder.setOrderId(order.getOrderId());
            saveOrder.setVehicleId(order.getVehicleId());
            nodeList = new ArrayList<>();
            List<Slot> slots = new ArrayList<>();
            Slot slot = new Slot("A", nodeList,noofOrder);
            Slot slot1 = new Slot("B", nodeList,noofOrder);
            Slot slot2 = new Slot("C", nodeList,noofOrder);
            slots.add(slot);
            slots.add(slot1);
            slots.add(slot2);
            System.out.println("slots are +++++"+slots.size());
            for(int i=0;i<slots.size();i++)
            {
                System.out.println("inside for loop");
                if(slots.get(i).getSlotType().equals(order.getSlotType()))
                {
                    noofOrder = slots.get(i).getNoOfOrders()+1;
//                    System.out.println("this type is equal"+slots.get(i).getSlotType());
//                    List<Node> nodes = slots.get(i).getNodeList();
//                    System.out.println("check the slot value is ####$$$$$$$$$$$########@@@@@@@@@@@"+nodes);
//                    nodes.add(node);
////                    slots.get(i).setNodeList(nodes);
                    slots.get(i).setNoOfOrders(noofOrder);
                    List<Node> nodes = new ArrayList<>();
                    nodes.add(node);
                    slots.get(i).setNodeList(nodes);
//                    System.out.println("this is after");
//                    System.out.println("this is the Slot which is set$$$$$$$$$$$$$$$$"+slots.get(i).getNodeList());
                }
//
            }
            saveOrder.setSlots(slots);
//            saveOrder.setSlots(slots);
//            saveOrder.setNoOfOrders(noofOrder);
            System.out.println("Before Routing service save for new save");
            routingRepository.save(saveOrder);
        }
//        optimizedSolution.optimizedCost(noofOrder, order.getX(), order.getY(), order.getDemand());
//       routingRepository.save(order);
        return "order added";
    }
    @Override
    public List<Vehicle> optimizedRoute(String slotType,String date) {
        Optional<SaveOrder> saveOrder = routingRepository.findById(date);
        List<Slot> slots = saveOrder.get().getSlots();
        int noOfOrder=0;
        List<Integer> demand = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        for(Slot slot:slots)
        {
            if(slot.getSlotType().equals(slotType))
            {
                nodes = slot.getNodeList();
                noOfOrder = slot.getNoOfOrders();
                for(Node node:nodes)
                {
                    demand.add(node.getDemand());
                }
            }
        }
        OptimizedSolutionImpl optimizedSolution= new OptimizedSolutionImpl();
        System.out.println("^**********INSERVICE^***************^"+optimizedSolution.optimizedCost(noOfOrder,nodes,demand));
        return optimizedSolution.optimizedCost(noOfOrder,nodes,demand);
    }
}
