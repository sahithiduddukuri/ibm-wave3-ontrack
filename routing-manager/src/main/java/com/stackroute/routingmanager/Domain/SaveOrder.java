package com.stackroute.routingmanager.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
public class SaveOrder {

    private int orderId;
    private int vehicleId;
    private String orderLoc;
    @Id
    private String orderDate; //selected slot date
    //private String selectedSlotType;
//    private int noOfOrders;
    private List<Slot> slots;
    // private String slotNo;

    public SaveOrder() {
    }
}
