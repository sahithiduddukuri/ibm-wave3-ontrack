package com.stackroute.recommendationservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Category {

    @Id
    private long id;
    private String productType;

}