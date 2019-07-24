package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class City {

    @GraphId
    private long cityId;
    private String cityName;

    public City() {
    }

    public City(long cityId, String cityName) {
        this.cityId=cityId;
        this.cityName = cityName;
    }


    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
