package com.stackroute.routingmanager.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {

    private int orderId;
    private int vehicleId;
    private String orderLoc;
    private double x;
    private double y;
    private String orderDate;
    private int demand;
    private int noOfOrders;
    private Node node;
    private String slotType;

    public Order() {
    }

}
