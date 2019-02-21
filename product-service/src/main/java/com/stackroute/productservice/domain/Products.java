package com.stackroute.productservice.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
    @Id

    private int productId;
    private String productName;
    private String productType;
    private String imageURL;
    private String mrp;
    private String price;
    private String dimension;
    private  String weight;
    private String size;
    private String gender;
    private String description;
    private String brand;
    private String colour;


}
