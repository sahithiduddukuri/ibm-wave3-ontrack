package com.stackroute.deliverymanager.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectedSlot {

    @Id
    private String orderDate;
    private String  date;
    private String slotType;
    private List<Product> productList;
    private  String responseId;
    private int orderId;
    private int productCount;

    public SelectedSlot(@JsonProperty String orderDate,@JsonProperty String date,@JsonProperty String slotType,@JsonProperty List<Product> productList,@JsonProperty String responseId,@JsonProperty int orderId,@JsonProperty int productCount) {
        this.orderDate = orderDate;
        this.date = date;
        this.slotType = slotType;
        this.productList = productList;
        this.responseId = responseId;
        this.orderId = orderId;
        this.productCount = productCount;
    }
}
