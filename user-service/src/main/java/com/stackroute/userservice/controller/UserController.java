package com.stackroute.userservice.controller;

import com.stackroute.kafka.domain.Producer;
import com.stackroute.kafka.domain.Space;
import com.stackroute.kafka.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExists;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/v1")
public class UserController {
    UserService userService;

    @Autowired
    Producer producer;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user)  throws UserAlreadyExists {
        ResponseEntity responseEntity;
        try{
            userService.saveUser(user);
            producer.send(user);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        }catch (UserAlreadyExists ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;


    }



    @GetMapping("user")
    public ResponseEntity<?>getAllUsers(){
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PatchMapping ("user")
    public ResponseEntity<?> updateUsers(@RequestBody User user) throws  UserNotFoundException{
        ResponseEntity responseEntity;
        try{
            userService.updateUser(user);
            responseEntity=new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
        }
        catch(UserNotFoundException exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

 @GetMapping("/user/{name}")
    public ResponseEntity<User> getByName(@PathVariable String name){
        ResponseEntity responseEntity=new ResponseEntity<User>(userService.getByName(name),HttpStatus.OK);
        return responseEntity;
    }




    @DeleteMapping("user")
    public ResponseEntity<String> deleteUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try {
            boolean answer=userService.deleteUser(user);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }
}
