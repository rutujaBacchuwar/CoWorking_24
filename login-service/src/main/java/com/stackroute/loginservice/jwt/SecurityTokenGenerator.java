package com.stackroute.loginservice.jwt;

import com.stackroute.loginservice.domain.User1;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(User1 user);
}
