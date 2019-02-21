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
    int userId;
    String userName;
    String mobileNo;
    String emailId;
    String dob;
    String gender;

}