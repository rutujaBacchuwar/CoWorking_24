package com.stackroute.kafka.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MyAddress {

    int pincode;

    String buildingNumber;
    String area;
    String city;
    String state;
    String country;

    public MyAddress() {
    }

    public MyAddress(String buildingNumber, String area, String city, String state, String country, int pincode) {
        this.buildingNumber = buildingNumber;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "buildingNumber='" + buildingNumber + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                '}';
    }


}
