package com.stackroute.routingmanager.Domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class RouteDTO {

    private Node node;
    public int nodeId;
    public double node_X , node_Y;
    public ArrayList<Node> Route = new ArrayList<Node>();

    @Autowired
    public RouteDTO(Node node) {
        this.node = node;
        this.nodeId = node.getNodeId();
        this.node_X = node.getNode_X();
        this.node_Y = node.getNode_Y();
        this.Route.clear();
    }
}
