package com.stackroute.kafka.domain;



public class Location {



    String locationName;
    double latitude;
    double longitude;
    int locationId;

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

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
