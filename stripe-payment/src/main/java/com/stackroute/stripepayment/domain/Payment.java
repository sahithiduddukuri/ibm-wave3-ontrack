package com.stackroute.stripepayment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    String nameOnCard;
    String cardNumber;
    String epiryMonth;
    String expiryYear;
    String cvc;
    List<Integer> products;

}
