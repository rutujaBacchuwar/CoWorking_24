package com.stackroute.recommendation.controller;


import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.domain.IsIn;
import com.stackroute.recommendation.service.IsInRelationshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/api/IsIn")
public class IsInRelationshipController {

    IsInRelationshipServiceImpl isInRelationshipService;

    @Autowired
    public IsInRelationshipController(IsInRelationshipServiceImpl isInRelationshipService) {
        this.isInRelationshipService = isInRelationshipService;
    }

    @GetMapping("/allRelationship")
    public Collection<IsIn> getRelationship(){
        return isInRelationshipService.getRelationship();
    }

    @PostMapping("/newRelation/{locationName}/{cityName}")
    public IsIn createRelationShip(@PathVariable String locationName,@PathVariable String cityName){
        return isInRelationshipService.createrelationship(locationName,cityName);
    }

//
//    @GetMapping("/recommendationLocCity")
//    public Collection<Space> recommendationLoc() {
//        return isInRelationshipService.getSpaceWithCity();
//    }

    @GetMapping("/recommendationLocCity/{cityName}")
    public Collection<Space> recommendationLoc(@PathVariable String cityName) {
        return isInRelationshipService.getSpaceWithCity(cityName);
    }

}
