package com.stackroute.productssearchservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productType;
    private String imageURL;
    private String mrp;
    private String price;
    private String dimension;
    private String weight;
    private String size;
    private String gender;
    private String description;
    private String brand;
    private String colour;

}
