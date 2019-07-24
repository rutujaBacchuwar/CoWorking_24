package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.City;
import com.stackroute.recommendation.exception.AlreadyExistException;

import java.util.Collection;

public interface CityService {

    public Collection<City> getall();

    public City saveCity(String cityName) throws AlreadyExistException;

}
