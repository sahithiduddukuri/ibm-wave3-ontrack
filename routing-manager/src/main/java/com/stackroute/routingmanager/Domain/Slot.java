package com.stackroute.routingmanager.Domain;

import lombok.Data;

@Data
public class Slot {

    private String slotType;
    private int cost;
    private boolean status;
    private int noOfOrders;
    private int vehicleId;

    public Slot() {
    }
}
