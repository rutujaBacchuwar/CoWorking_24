package com.stackroute.recommendation.controller;


import com.stackroute.recommendation.domain.User;
import com.stackroute.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/api/user")
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Collection<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{name}")
    public User findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    //To create new user
    @PostMapping("/newUser")
    public User saveUser(@RequestBody User user) {
        User user1 = userService.create(user.getId(), user.getName(), user.getEmailId(),user.getUid());
        return user1;
    }

    //To delete user by id
    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable Long id) {
        return userService.delete(id);
    }


    //To delete all users
    @DeleteMapping("/userGone")
    public String deleteAll() {
        userService.deleteAll();
        return "deletedAll";
    }

    //To update user by id
    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user.getName(), user.getEmailId(),user.getUid());
    }


}
