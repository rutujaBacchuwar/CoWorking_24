package com.stackroute.loginservice.service;

import com.stackroute.loginservice.domain.User1;



import java.util.List;

public interface UserService {
    User1 saveUser(User1 user) throws Exception;
    List<User1> getAllUsers();  ///RETRIEVE users

    User1 findByUserIdAndPassword(String name, String password);

}
