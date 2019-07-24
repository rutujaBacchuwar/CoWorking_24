package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Location;
import com.stackroute.recommendation.exception.AlreadyExistException;
import com.stackroute.recommendation.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocationServiceImpl implements LocationService {

    LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location findByName(String locationName) {
        return locationRepository.getNode(locationName);
    }

    @Override
    public Collection<Location> getAll() {
        return locationRepository.getAll();
    }

    @Override
    public Location create(long locationId, String locationName, double latitude, double longitude)throws AlreadyExistException {
//        System.out.println("================"+locationRepository.existByName(locationName).toString());
        if(locationRepository.existByName(locationName)!=null){
            throw new AlreadyExistException("Location already Exist");
        }

        return locationRepository.createNode(locationId,locationName,latitude,longitude);
    }

    @Override
    public Location delete(Long locationId) {
        return locationRepository.deleteNode(locationId);
    }

    @Override
    public Location deleteAll() {
        return locationRepository.deleteAllNodes();
    }

    @Override
    public Location update(long locationId, String locationName) {
        return locationRepository.updateNode(locationId,locationName);
    }
}
