package com.stackroute.deliverymanager.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

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

}
