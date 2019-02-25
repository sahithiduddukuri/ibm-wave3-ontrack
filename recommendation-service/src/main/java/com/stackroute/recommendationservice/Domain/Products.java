package com.stackroute.recommendationservice.Domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Products.class)
public class Products {
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("productName")
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

    private Brand brands;
    private Product product;
    private Category category;
    private Size sizes;

    @Override
    public String toString() {
        return "Products{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", mrp='" + mrp + '\'' +
                ", price='" + price + '\'' +
                ", dimension='" + dimension + '\'' +
                ", weight='" + weight + '\'' +
                ", size='" + size + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", brands=" + brands +
                ", product=" + product +
                ", category=" + category +
                ", sizes=" + sizes +
                '}';
    }
}
