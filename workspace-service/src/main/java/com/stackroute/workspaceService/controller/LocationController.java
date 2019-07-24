package com.stackroute.workspaceService.controller;


import com.stackroute.workspaceService.domain.*;
import com.stackroute.workspaceService.exception.LocationNotFoundException;
import com.stackroute.workspaceService.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1")
public class LocationController {

    LocationService locationService;
    MySpace myspace = new MySpace();
    MyAddress address = new MyAddress();
    MyDimension myDimension = new MyDimension();
    MyCategory myCategory=new MyCategory();

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("location")
    public ResponseEntity<?> saveLocation(@RequestBody MyLocation myLocation) /*throws LocationAlreadyExists*/ {
        System.out.println("Location Object:" + myLocation.toString());
        myspace = myLocation.getMySpace();
        myLocation.setMySpace(myspace);
        address = myLocation.getAddress();
        myLocation.setAddress(address);
        myDimension = myLocation.getMyDimension();
        myLocation.setMyDimension(myDimension);
       /* myCategory = myLocation.getMycategory();
        myLocation.setMycategory(myCategory);*/
        ResponseEntity responseEntity;
        //try {
            locationService.saveLocation(myLocation);
            responseEntity = new ResponseEntity<String>(" Location Successfully Saved", HttpStatus.CREATED);

        //} catch (LocationAlreadyExists ex) {
            //responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        //}
        return responseEntity;


    }


    @GetMapping("location")
    public ResponseEntity<?> getLocation() {
        return new ResponseEntity<List<MyLocation>>(locationService.getLocation(), HttpStatus.OK);
    }


    @PatchMapping("location")
    public ResponseEntity<?> updateLocation(@RequestBody MyLocation myLocation) throws LocationNotFoundException {
        ResponseEntity responseEntity;
        try {
            locationService.updateLocation(myLocation);
            responseEntity = new ResponseEntity<String>(" location Updated Successfully", HttpStatus.CREATED);
        } catch (LocationNotFoundException exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @DeleteMapping("location")
    public ResponseEntity<String> deleteLocation(@RequestBody MyLocation myLocation) {
        ResponseEntity responseEntity;
        try {
            boolean answer = locationService.deleteLocation(myLocation);
            return new ResponseEntity<String>(" Location Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }


    @GetMapping("location/{locationName}")
    public ResponseEntity<?>getByLocation(@PathVariable String locationName)
    {
        System.out.println("ofdyfey");
        List<MyLocation> list = new ArrayList<MyLocation>();
        list= locationService.findByLocation(locationName);
        System.out.println("st9t98dsa"+list.toString());
        ResponseEntity responseEntity=new ResponseEntity(list,HttpStatus.OK);
        System.out.println(responseEntity);
        return responseEntity;
    }
}



