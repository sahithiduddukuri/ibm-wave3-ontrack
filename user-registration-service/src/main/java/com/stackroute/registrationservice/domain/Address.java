package com.stackroute.registrationservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address
{
    private String addressDetails;
    private String city;
    private String state;
    private String country;
}
