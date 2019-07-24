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

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

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
}



