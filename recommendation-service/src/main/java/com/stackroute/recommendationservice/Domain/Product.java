package com.stackroute.recommendationservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private int productId;
    private String productName;

}
