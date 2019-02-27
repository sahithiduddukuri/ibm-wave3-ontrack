package com.stackroute.containermanagerservice.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Containers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Container
{
    @Id
    private int orderId;
    private int productId;
    private int productWeight;
    private int productLength;
    private int productWidth;
    private int productBreadth;
    private boolean isFragile;
    private String deliveryLocation;
    private String orderDate;
    private String orderTime;
    private String conatinerId;
    private String date;
    private String slotNumber;

//    public void findAvailableContainer(int productLength,int productWidth,int productBreadth)
//    {
//        this.productLength=productLength;
//        this.productBreadth=productBreadth;
//        this.productWidth=productWidth;
//        int volume=(productBreadth*productLength*productWidth);
//
//    }
}
