package com.stackroute.recommendationservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int userId;
    private String userName;
    private String mobileNo;
    private String emailId;
    private String dob;
    private String gender;

}