package com.stackroute.registrationservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
public class Address
{
    private String addressDetails;
    private String city;
    private String state;
    private String country;

//    public Address(String addressDetails, String city, String state, String country) {
//        this.addressDetails = addressDetails;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//    }
//
//    public String getAddressDetails() {
//        return addressDetails;
//    }
//
//    public void setAddressDetails(String addressDetails) {
//        this.addressDetails = addressDetails;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "addressDetails='" + addressDetails + '\'' +
//                ", city='" + city + '\'' +
//                ", state='" + state + '\'' +
//                ", country='" + country + '\'' +
//                '}';
//    }
}
