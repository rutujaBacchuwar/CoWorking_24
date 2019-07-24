package com.stackroute.kafka.domain;

import java.util.Arrays;

public class Amenities {

    String[] amenities;

    public Amenities() {
    }

    public Amenities(String[] amenities) {
        this.amenities = amenities;
    }

    public String[] getAmenities() {
        return amenities;
    }

    @Override
    public String toString() {
        return "Amenities{" +
                "amenities=" + Arrays.toString(amenities) +
                '}';
    }
}

