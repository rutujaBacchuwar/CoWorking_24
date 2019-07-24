package com.stackroute.userservice.service;

import com.stackroute.kafka.domain.Space;
import com.stackroute.kafka.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExists;
import com.stackroute.userservice.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User saveUser(User user) throws  UserAlreadyExists;
    public boolean deleteUser(User user) throws Exception;
    public User updateUser(User user) throws UserNotFoundException;
 public User getByName(String name);

    

}
