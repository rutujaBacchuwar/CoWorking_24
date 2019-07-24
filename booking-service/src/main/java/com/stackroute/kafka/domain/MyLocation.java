package com.stackroute.kafka.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MyLocation {

    int locationId;
    String locationName;
    double latitude;
    double longitude;

    public MyLocation() {
    }

    public MyLocation(int locationId, String locationName, double latitude, double longitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "MyLocation{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
