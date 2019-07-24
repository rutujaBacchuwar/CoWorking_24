package com.stackroute.kafka.domain;


import java.util.Arrays;

public class Amenities {

    String[] amenities;

    public Amenities() {
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "amenities=" + Arrays.toString(amenities) +
                '}';
    }

    public Amenities(String[] amenities) {
        this.amenities = amenities;
    }

    public String[] getAmenities() {
        return amenities;
    }
}

