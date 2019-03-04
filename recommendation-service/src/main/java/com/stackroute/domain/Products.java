package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Products {
    @Id
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productType")
    private String productType;
    @JsonProperty("productTypeId")
    private String productTypeId;
    @JsonProperty("imageURL")
    private String imageURL;
    @JsonProperty("weight")
    private  String weight;
    @JsonProperty("size")
    private String size;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("description")
    private String description;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("colour")
    private String colour;
    @JsonProperty("brandId")
    private String brandId;
    @JsonProperty("mrp")
    private String mrp;
    @JsonProperty("price")
    private String price;
    @JsonProperty("dimension")
    private String dimension;

}
