package com.stackroute.recommendation.controller;


import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.service.LocatedService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/api/located")
public class LocatedController {


    LocatedService locatedService;

    public LocatedController(LocatedService locatedService) {
        this.locatedService = locatedService;
    }

    //To get relationship
    @GetMapping("/relationship")
    public Collection<Space> getRelationship() {
        return locatedService.getRelationship();
    }

    //create relationship
    @PostMapping("/newRelationship/space/{spaceName}/{locationName}")
    public Space relationship(@PathVariable String spaceName, @PathVariable String locationName) {
        Space space1 = locatedService.createRelationship(spaceName, locationName);
        return space1;
    }

    //create relationship
    @PostMapping("/newRelationship/category/{categoryName}/{locationName}")
    public Category relationshipLoc(@PathVariable String categoryName, @PathVariable String locationName) {
        Category category1 = locatedService.createRelationshipLoc(categoryName, locationName);
        return category1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship/category")
    public Category relationshipdeleteCategory() {
        Category category1 = locatedService.deleteRelationshipcat();
        return category1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship/space")
    public Space relationshipdelete() {
        Space space1 = locatedService.deleteRelationship();
        return space1;
    }

    //To get recommondation
    @GetMapping("/recommendationLoc/{name}")
    public Collection<Space> recommendationLoc(@PathVariable String name) {
        return locatedService.createRecommendationLoc(name);
    }


}
