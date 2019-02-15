package com.stackroute.registrationservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Registrations")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Registration
{
    @Id
    private int id;
    private String name;
    private String userId;
    private String password;
    private String emailId;

    public Registration(int id,String name, String userId, String password, String emailId) {
        this.id=id;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.emailId = emailId;
    }
}
