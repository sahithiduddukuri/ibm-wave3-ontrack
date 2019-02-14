package com.stackroute.recommendservice.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class User {

    @Id
    int id;
    String name;
    String phno;
    String emailId;
    String gender;
   /* @Relationship(type="Purchases",direction=Relationship.OUTGOING)
    private Product products;
*/
    public User() {
    }

    public User(String name, String phno, String emailId, String gender) {
        this.name = name;
        this.phno = phno;
        this.emailId = emailId;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
