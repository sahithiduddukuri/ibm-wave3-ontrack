package com.stackroute.deliverymanager.Domain;

import lombok.Data;

@Data
public class Node {


    public Node() {
    }

    public int nodeId;
    public int node_X , node_Y; //Node Coordinates
    public int demand; //Node Demand if Customer
    public boolean isRouted;
    private boolean isDepot; //True if it Depot Node


    public Node(int depot_x, int depot_y) //Cunstructor for depot
    {
        this.nodeId = 0;
        this.node_X = depot_x;
        this.node_Y = depot_y;
        this.isDepot = true;
    }

    public Node(int id , int x, int y, int demand) //Cunstructor for Customers
    {
        this.nodeId = id;
        this.node_X = x;
        this.node_Y = y;
        this.demand = demand;
        this.isRouted = false;
        this.isDepot = false;
    }


}
