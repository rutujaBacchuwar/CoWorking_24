package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {

    public Collection<User> getAllUsers();
    public User findByName(String name);
    public User create(long id, String name,String email,int uid);
    public User delete(Long id);
    public User deleteAll();
    public User updateUser(long id, String name,String email,int uid);
}
