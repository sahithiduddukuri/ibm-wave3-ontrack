package com.stackroute.deliverymanager.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order
{
    private  String responseId;
    private int orderId;
    private List<Product> productList;
    @Id
    private String orderDate;
    private int productCount;


    public Order(@JsonProperty String responseId,@JsonProperty int orderId,@JsonProperty List<Product> productList,@JsonProperty String orderDate,@JsonProperty int productCount) {
        this.responseId = responseId;
        this.orderId = orderId;
        this.productList = productList;
        this.orderDate = orderDate;
        this.productCount = productCount;
    }


}
