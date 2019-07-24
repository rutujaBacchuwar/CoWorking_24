package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {

    @Id
    int pincode;

    String buildingNumber;
    String area;
    String city;
    String state;
    String country;

    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Address() {
    }

    public Address(int pincode, String buildingNumber, String area, String city, String state, String country) {
        this.pincode = pincode;
        this.buildingNumber = buildingNumber;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
