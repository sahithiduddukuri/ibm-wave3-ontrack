package com.stackroute.routingmanager.Domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Order {

    private int orderId;
    private int vehicleId;
    private String orderLoc;
    private int x;
    private int y;
    private LocalDate date;
    private int demand;

    public Order() {
    }
}
