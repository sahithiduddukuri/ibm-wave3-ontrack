package com.stackroute.containermanager.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectedSlot {
    @Id
    private LocalDate orderDate;
    private LocalDate date;
    private String slotType;
    private List<Product> productList;
    private  String responseId;

}
