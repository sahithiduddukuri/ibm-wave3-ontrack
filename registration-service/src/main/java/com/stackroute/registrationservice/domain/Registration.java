package com.stackroute.registrationservice.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Registrations")
@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = Registration.class)
public class Registration
{
    @Id
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("password")
    private String password;
    @JsonProperty("emailId")
    private String emailId;

    public Registration(int id,String name, String userId, String password, String emailId) {
        this.id=id;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
