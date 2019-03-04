package com.stackroute.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class Brand {

    @Id
    private String brandId;
    private String brand;

}
