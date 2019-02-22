package com.stackroute.recommendationservice.Domain;

import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@NoArgsConstructor
public class Brand {

    @Id
    int id;

    String bradName;

    public Brand(String bradName) {
        this.bradName = bradName;
    }

    public String getBradName() {
        return bradName;
    }

    public void setBradName(String bradName) {
        this.bradName = bradName;
    }
}
