package com.stackroute.routingmanager.Domain;


import lombok.Data;

@Data
public class Location
{
    private String location;
//    private String orderLatitude;
//    private String orderLongitude;

    public Location() {
    }

    public Location(String location) {
        this.location = location;
    }
}
