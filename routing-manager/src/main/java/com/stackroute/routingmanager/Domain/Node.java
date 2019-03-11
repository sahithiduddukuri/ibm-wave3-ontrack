package com.stackroute.routingmanager.Domain;

import lombok.Data;

@Data
public class Node {


    public Node() {
    }

    public int nodeId;
    public double node_X , node_Y; //Node Coordinates
    public int demand; //Node Demand if Customer
    public boolean isRouted;
    private boolean isDepot; //True if it Depot Node


    public Node(double depot_x,double depot_y) //Cunstructor for depot
    {
        this.nodeId = 0;
        this.node_X = depot_x;
        this.node_Y = depot_y;
        this.isDepot = true;
    }

    public Node(int id ,double x, double y, int demand) //Cunstructor for Customers
    {
        this.nodeId = id;
        this.node_X = x;
        this.node_Y = y;
        this.demand = demand;
        this.isRouted = false;
        this.isDepot = false;
    }


}
