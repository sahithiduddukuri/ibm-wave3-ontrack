package com.stackroute.deliverymanager.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public Vehicle() {
    }

    public Vehicle(@JsonProperty int id,@JsonProperty int cap)
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
