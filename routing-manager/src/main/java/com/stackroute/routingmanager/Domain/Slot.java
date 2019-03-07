package com.stackroute.routingmanager.Domain;

import lombok.Data;

import java.util.List;

@Data
public class Slot {

    private String slotType;
    private List<Node> nodeList;

    public Slot(String slotType, List<Node> nodeList) {
        this.slotType = slotType;
        this.nodeList = nodeList;
    }

    public Slot() {
    }
}
