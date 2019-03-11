package com.stackroute.deliverymanagerlogin.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EcommerceInput {

    private int orderId;
    private List<Product> products;
    private String deliveryLocation;
    private String orderDate;

}
