package com.stackroute.recommendation.controller;

import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.service.ContainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/api/contains")

public class ContainsController {

    ContainsService containsService;

    @Autowired
    public ContainsController(ContainsService containsService) {
        this.containsService = containsService;
    }

    //To get relationship
    @GetMapping("/relationship")
    public Collection<Space> getRelationship() {
        return containsService.getRelationship();
    }

    // create relationship
    @PostMapping("/newRelationship/{spaceId}")
    public Space relationship(@PathVariable long spaceId) {
        Space space1 = containsService.createRelationship(spaceId);
        return space1;
    }

    //creating relationship between all nodes
    @PostMapping("/allRelationship")
    public Space relationshipAll() {
        Space space1 = containsService.createRelationshipAll();
        return space1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship")
    public Space relationshipdelete() {
        Space space1 = containsService.deleteRelationship();
        return space1;
    }

    //Recommendation based on price
    @GetMapping("/priceRecommendation/{name}")
        public Collection<Space> recommondtionPrice(@PathVariable String name) {
            return containsService.recommendationprice(name);
        }
    }

