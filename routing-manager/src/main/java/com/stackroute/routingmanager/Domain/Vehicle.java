package com.stackroute.routingmanager.Domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Vehicle {

    public int vehId;
    public ArrayList<Node> Route = new ArrayList<Node>();
    public int capacity;
    public int load;
    public int curLoc;
    public boolean closed;
    public double cost;

    public Vehicle() {
    }

    public Vehicle(int id, int cap)
    {
        this.vehId = id;
        this.capacity = cap;
        this.load = 0;
        this.curLoc = 0; //In depot Initially
        this.closed = false;
        this.Route.clear();
    }

    public void addNode(Node order)//Add Customer to Vehicle Route
    {
        Route.add(order);
        this.load +=  order.demand;
        this.curLoc = order.nodeId;
    }

    public boolean CheckIfFits(int dem) //Check if we have Capacity Violation
    {
        return ((load + dem <= capacity));
    }
}
