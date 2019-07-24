package com.stackroute.workspaceService.service;
import com.stackroute.workspaceService.exception.LocationNotFoundException;
import com.stackroute.workspaceService.repository.LocationRepository;
import com.stackroute.workspaceService.domain.MyLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    LocationRepository locationRepository;
    LocationService locationService;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {

        this.locationRepository = locationRepository;
    }

    @Override
    public List<MyLocation> getLocation() {
        return locationRepository.findAll();

    }

    @Override
    public MyLocation saveLocation(MyLocation location) /*throws LocationAlreadyExists*/ {
//        if (locationRepository.existsByLocationName(location.getLocationName()))
//            throw new LocationAlreadyExists("location Already Exists");

        MyLocation savedLocation = locationRepository.save(location);
        return savedLocation;
    }

    @Override
    public boolean deleteLocation(MyLocation location) throws Exception {
        if (locationRepository.existsByLocationId(location.getLocationId())) {
            locationRepository.deleteByLocationId(location.getLocationId());
            return true;
        } else {
            throw new Exception("Location you want to delete is not exist");
        }
    }

    @Override
    public MyLocation updateLocation(MyLocation location) throws LocationNotFoundException {
        if (locationRepository.existsByLocationId(location.getLocationId())) {
            MyLocation saveLocation = locationRepository.save(location);
            return saveLocation;
        } else {
            throw new LocationNotFoundException("Location not found");
        }
    }

    @Override
    public List<MyLocation> findByLocation(String locationName) {
        return locationRepository.findByLocationName(locationName);
    }
}

