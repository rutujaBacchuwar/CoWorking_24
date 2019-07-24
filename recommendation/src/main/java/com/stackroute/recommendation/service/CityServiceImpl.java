package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.City;
import com.stackroute.recommendation.exception.AlreadyExistException;
import com.stackroute.recommendation.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityServiceImpl implements CityService {

    public CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Collection<City> getall() {
        return cityRepository.getAll();
    }

    @Override
    public City saveCity(String cityName) throws AlreadyExistException {

        if (cityRepository.existByName(cityName)!=null){
            throw new AlreadyExistException("City already Exist");
        }

        return cityRepository.createNode(cityName);
    }
}
