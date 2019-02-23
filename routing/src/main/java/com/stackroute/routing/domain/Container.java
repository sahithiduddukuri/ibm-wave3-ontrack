package com.stackroute.routing.domain;

import lombok.Data;

@Data
public class Container {

    int containerId;
    int containerCapacity;
    Node[] orders;

    public Container(int containerId, int containerCapacity , Node[] nodes) {
        this.containerId = containerId;
        this.containerCapacity = containerCapacity;
        this.orders = nodes;
    }


}
