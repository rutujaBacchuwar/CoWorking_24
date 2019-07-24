package com.stackroute.loginservice.repository;

import com.stackroute.loginservice.domain.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User1,Integer> {

    User1 findByNameAndPassword(String name, String password);


    boolean existsByName(String name);
}
