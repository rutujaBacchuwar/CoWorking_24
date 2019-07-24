package com.stackroute.kafka.domain;

import lombok.Data;

@Data
public class Location {
    String locationName;
    double latitude;
    double longitude;
    int locationId;

    public Location() {
    }

    public Location(String locationName, double latitude, double longitude, int locationId) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationId = locationId;
    }


    public String getLocationName() {
        return locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public  int getLocationId(){
        return  locationId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", locationId=" + locationId +
                '}';
    }
}

