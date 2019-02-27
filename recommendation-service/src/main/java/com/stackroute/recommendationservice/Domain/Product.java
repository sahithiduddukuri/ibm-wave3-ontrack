package com.stackroute.recommendationservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productType;
    private String productTypeId;
    private String imageURL;
    private String mrp;
    private String price;
    private String dimension;
    private String weight;
    private String size;
    private String gender;
    private String description;
    private String brand;
    private String brandId;
    private String colour;


}
