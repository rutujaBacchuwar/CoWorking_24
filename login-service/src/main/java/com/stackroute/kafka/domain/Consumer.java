package com.stackroute.kafka.domain;
import com.stackroute.loginservice.domain.User1;
import com.stackroute.loginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

public class Consumer {
    private UserService userService;

    @Autowired
    public Consumer(UserService userService) {
        this.userService = userService;
    }

    User1 user1= new User1();

    @KafkaListener(topics = "userTopic5")
        public void receive(@Payload User user){
        System.out.println(user.toString());
//        System.out.println("User-Id:"+user.getUid());
//        System.out.println("Name:"+user.getName());
//        System.out.println("Password:"+user.getPassword());
        user1.setUid((user.getUid()));
        System.out.println("UID:"+user1.getUid());
        user1.setName(user.getName());
        System.out.println("NAME:"+user1.getName());
        user1.setPassword(user.getPassword());
        System.out.println("PASSWORD:"+user1.getPassword());
        System.out.println(user1.toString());
        user1.setRole(user1.getRole());


        try{
            userService.saveUser(user1);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

            System.out.println(user.toString());

        }

    }

