package com.stackroute.loginservice.service;

import com.stackroute.loginservice.domain.User1;
import com.stackroute.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    @Override
    public User1 saveUser(User1 user) throws Exception{
        if(userRepository.existsByName(user.getName())){
         throw new Exception("user already exist");
        }
            return userRepository.save(user);
    }

    @Override
    public List<User1> getAllUsers() {
        return userRepository.findAll();
    }

    @Override

    public User1 findByUserIdAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);

    }
}
