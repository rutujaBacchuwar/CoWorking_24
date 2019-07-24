package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.User;
import com.stackroute.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }


    @Override
    public User findByName(String name) {
        return userRepository.getNode(name);
    }

    @Override
    public User create(long id, String name, String email, int uid) {
        return userRepository.createNode(id,name,email,uid);
    }

    @Override
    public User delete(Long id) {
        return userRepository.deleteNode(id);
    }

    @Override
    public User deleteAll() {
        return userRepository.deleteAllNodes();
    }

    @Override
    public User updateUser(long id, String name, String email, int uid) {
        return userRepository.updateNode(id,name,email,uid);
    }
}
