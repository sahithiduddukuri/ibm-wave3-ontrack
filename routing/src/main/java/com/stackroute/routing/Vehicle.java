package com.stackroute.routing;

import java.util.ArrayList;

public class Vehicle {

    public int vehicle_Id;
    public ArrayList<Node> Route = new ArrayList<>();
    public int capacity; //how many containers can be filled in a truck
    public int load;
    public int currentLoc; //location where the vehicle is currently
    public boolean closed;

    //constructor for vehicle
    public Vehicle(int id , int cap) {
        this.vehicle_Id = id;
        this.capacity = cap;
        this.load = 0;
        this.currentLoc = 0;
        this.closed = false;
        this.Route.clear();
    }

    //add new order to container and that container is added as new node
    public void addNode(Node Container) {
        Route.add(Container);
        this.load += Container.demand;
        this.currentLoc = Container.nodeId;
    }

    //Check if container can fit in vehicle
    public boolean checkIfFits(int fill) {
        return (load + fill <= capacity);
    }
}
