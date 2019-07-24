package com.stackroute.kafka.domain;

import lombok.Data;

import java.util.Arrays;

@Data
public class Amenities {

    String[] amenities;

    public Amenities() {
        super();
    }

    public Amenities(String[] amenities) {
        this.amenities = amenities;
    }

    public String[] getAmenities() {
        return amenities;
    }

    public void setAmenities(String[] amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "amenities=" + Arrays.toString(amenities) +
                '}';
    }
}
