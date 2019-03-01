package com.stackroute.routingmanager.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
public class SaveOrder {

//    @Id
//    private String recordId;
    private int orderId;
    private int vehicleId;
    private String orderLoc;
    @Id
    private LocalDate date;
    private int noOfOrders;
    private List<Node> nodes;
    // private String slotNo;

    public SaveOrder() {
    }
}
