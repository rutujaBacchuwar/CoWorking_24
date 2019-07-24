package com.stackroute.loginservice.controller;

import com.stackroute.loginservice.jwt.SecurityTokenGenerator;
import com.stackroute.loginservice.domain.User1;
import com.stackroute.loginservice.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> login(@RequestBody User1 loginDetails) throws Exception {


        String username = loginDetails.getName();
        String password = loginDetails.getPassword();

        if (username == null || password == null) {

            throw new Exception("password or username is null");
        }

        User1 user = userService.findByUserIdAndPassword(username, password);

        if (user == null) {
            throw new Exception("username is invalid");
        }

        String fetchedPassword = user.getPassword();

        if (!password.equals(fetchedPassword)) {
            throw new Exception("Incorrect password");
        }

        // generating token

        SecurityTokenGenerator securityTokenGenerator = (User1 userDetails) -> {
            String jwtToken = "";

            jwtToken = Jwts.builder().setId(""+user.getUid()).setSubject(user.getRole()).setAudience(user.getName()).setIssuedAt(new Date())

                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

            Map<String, String> map1 = new HashMap<>();

            map1.put("token", jwtToken);

            map1.put("message", "User successfully logged in");

            return map1;

        };
        Map<String, String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<List<User1>>(userService.getAllUsers(), HttpStatus.OK);
    }

   // @ApiOperation(value = "It saves all the user details")
    @PostMapping("/users/user")
    public ResponseEntity<?> saveEvent(@RequestBody User1 user)throws Exception  {

        return new ResponseEntity<User1>(userService.saveUser(user), HttpStatus.OK);

    }


}
