package com.stackroute.routing;

public class Node {
    //nodes belong to locations
    public int nodeId;
    public int node_x,node_y; //x,y coordinates
    public int demand; //node demand if new delivery arrives
    public boolean isRouted;
    private boolean isDepot; //true if it is depot

    //constructor for depot
    public Node(int depot_x,int depot_y) {
        this.nodeId = 0;
        this.node_x = depot_x;
        this.node_y = depot_y;
        this.isDepot = true;
    }

    //constructor for node i.e any location other than depot
    public Node(int id, int x, int y, int demand ) {
        this.nodeId = id;
        this.node_x = x;
        this.node_y = y;
        this.demand = demand;
        this.isRouted = false;
        this.isDepot = false;
    }
}
