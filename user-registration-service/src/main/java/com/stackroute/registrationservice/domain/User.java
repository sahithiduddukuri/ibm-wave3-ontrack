package com.stackroute.registrationservice.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "Registrations")
@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = User.class)
public class User
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
    @JsonProperty("mobileNo")
    private String mobileNo;
    @JsonProperty("dateofBirth")
    private String dateofBirth;
    @JsonProperty("gender")
    private String gender;
    List<Product> products;
    public User(int id, String name, String userId, String password, String mobileNo, String dateofBirth, String gender) {
        this.id=id;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.mobileNo = mobileNo;
        this.dateofBirth=dateofBirth;
        this.gender=gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dateofBirth='" + dateofBirth + '\'' +
                ", gender='" + gender +
                '}';
    }
}
