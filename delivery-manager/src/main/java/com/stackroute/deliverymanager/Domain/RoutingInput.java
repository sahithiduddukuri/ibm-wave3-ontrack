package com.stackroute.deliverymanager.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoutingInput {

    private int orderId;
    private int vehicleId;
    private String orderLoc;
    private String orderDate;
    private int demand;
    private String slotType;
}
