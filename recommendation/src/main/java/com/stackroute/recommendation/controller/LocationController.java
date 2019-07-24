package com.stackroute.recommendation.controller;


import com.stackroute.recommendation.domain.Location;
import com.stackroute.recommendation.exception.AlreadyExistException;
import com.stackroute.recommendation.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/api/location")
public class LocationController {

    public LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{locationName}")
    public Location findByName(@PathVariable String locationName) {
        return locationService.findByName(locationName);
    }

    //To get all users
    @GetMapping("/allLocation")
    public Collection<Location> getAll() {
        return locationService.getAll();
    }


    // To create new user
    @PostMapping("/newLocation")
    public Location save(@RequestBody Location location) {
        System.out.println("idwufcxgwcdifcwi"+location.toString());
        Location location1=new Location();
        try {
            location1 = locationService.create(location.getLocationId(), location.getLocationName(), location.getLatitude(), location.getLongitude());
            return location1;
        }catch (AlreadyExistException a){
            a.getMessage();
        }

        return location1;
    }

    //To delete user by id
    @DeleteMapping("/{id}")
    public Location delete(@PathVariable Long id) {
        return locationService.delete(id);
    }


    //To delete all users
    @DeleteMapping("/gone")
    public String deleteAll() {
        locationService.deleteAll();
        return "deletedAll";
    }

    //To update user by id
    @PutMapping("/{id}/{locationName}")
    public Location update(@PathVariable long id, @PathVariable String locationName) {
        return locationService.update(id,locationName);
    }

}
