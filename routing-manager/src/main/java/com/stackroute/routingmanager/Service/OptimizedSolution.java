package com.stackroute.routingmanager.Service;

import com.stackroute.routingmanager.Domain.Node;
import com.stackroute.routingmanager.Domain.Vehicle;

import java.util.List;

public interface OptimizedSolution {

    public List<Vehicle> optimizedCost(int noOfOrders , List<Node> nodeList, List<Integer> demand);

}
