package com.stackroute.recommendation.controller;

import com.stackroute.recommendation.domain.User;
import com.stackroute.recommendation.service.BookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/api/booked")
public class BookedController {

    BookedService bookedService;

    @Autowired
    public BookedController(BookedService bookedService) {
        this.bookedService = bookedService;
    }

    //To get relationship
    @GetMapping("/relationship")
    public Collection<User> getRelationship() {
        return bookedService.getRelationship();
    }

    @PostMapping("/newRelationship/{name}/{categoryName}/{spaceId}")
    public User relationship(@PathVariable String name, @PathVariable String categoryName, @PathVariable long spaceId) {
        User user1 = bookedService.createRelationship(name, categoryName, spaceId);
        return user1;
    }

    //To delete relationship
    @DeleteMapping("/deleteRelationship")
    public User relationshipdelete() {
        User user1 = bookedService.deleteRelationship();
        return user1;
    }

}
