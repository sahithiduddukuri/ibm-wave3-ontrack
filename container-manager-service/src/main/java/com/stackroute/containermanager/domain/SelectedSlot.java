package com.stackroute.containermanager.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectedSlot {
    @Id
    private String orderDate;
    private String  slotDate;
    private String slotType;
    private List<Product> productList;
    private int productCount;
    private  String responseId;
    private int orderId;

    public SelectedSlot(String orderDate, String slotDate, String slotType, List<Product> productList, String responseId, int orderId) {
        this.orderDate = orderDate;
        this.slotDate = slotDate;
        this.slotType = slotType;
        this.productList = productList;
        this.responseId = responseId;
        this.orderId = orderId;
    }

    private String orderLoc;



}
