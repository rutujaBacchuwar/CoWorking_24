package com.stackroute.workspaceService.controller;

import com.stackroute.workspaceService.domain.MySpace;
import com.stackroute.workspaceService.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value="api/v1")
public class SpaceController {
    SpaceService spaceService;

    @Autowired
    public SpaceController(SpaceService spaceService) {

        this.spaceService = spaceService;
    }

    @PostMapping("savespace")
    public ResponseEntity<?> saveSpace(@RequestBody MySpace myspace){
        ResponseEntity responseEntity = new ResponseEntity<MySpace>(spaceService.saveSpace(myspace), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("space/{name}")
    public ResponseEntity<?> getByName(@PathVariable String spaceName){
        ResponseEntity responseEntity=new ResponseEntity<MySpace>(spaceService.findBySpaceName(spaceName), HttpStatus.OK);
        return responseEntity;
    }
}
