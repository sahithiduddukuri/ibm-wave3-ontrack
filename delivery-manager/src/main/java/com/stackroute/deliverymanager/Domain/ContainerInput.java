package com.stackroute.deliverymanager.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ContainerInput {

    private int orderId;
    private List<Product> productList;
    private String orderDate;
}
