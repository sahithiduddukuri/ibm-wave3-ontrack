package com.stackroute.containermanager.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
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
}
