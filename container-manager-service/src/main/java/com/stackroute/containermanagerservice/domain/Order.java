package com.stackroute.containermanagerservice.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Containers")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Order
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
    private Date orderDate;
    private Date orderTime;

//    public void findAvailableContainer(int productLength,int productWidth,int productBreadth)
//    {
//        this.productLength=productLength;
//        this.productBreadth=productBreadth;
//        this.productWidth=productWidth;
//        int volume=(productBreadth*productLength*productWidth);
//
//    }

    public Order(int orderId, int productId, int productWeight, int productLength, int productWidth, int productBreadth, boolean isFragile, String deliveryLocation, Date orderDate, Date orderTime) {
        this.orderId = orderId;
        this.productId = productId;
        this.productWeight = productWeight;
        this.productLength = productLength;
        this.productWidth = productWidth;
        this.productBreadth = productBreadth;
        this.isFragile = isFragile;
        this.deliveryLocation = deliveryLocation;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public int getProductLength() {
        return productLength;
    }

    public void setProductLength(int productLength) {
        this.productLength = productLength;
    }

    public int getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(int productWidth) {
        this.productWidth = productWidth;
    }

    public int getProductBreadth() {
        return productBreadth;
    }

    public void setProductBreadth(int productBreadth) {
        this.productBreadth = productBreadth;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
