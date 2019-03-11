package com.stackroute.routingmanager.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Slot {

    private String slotType;
    private List<Node> nodeList;
    private int noOfOrders;

    public Slot(String slotType, List<Node> nodeList , int noOfOrder) {
        this.slotType = slotType;
        this.nodeList = nodeList;
        this.noOfOrders = noOfOrder;
    }

    public Slot() {
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }
}
