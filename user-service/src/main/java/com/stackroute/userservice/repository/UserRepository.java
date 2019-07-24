package com.stackroute.userservice.repository;

import com.stackroute.kafka.domain.Space;
import com.stackroute.kafka.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    void deleteByEmailId(String emailId);
    boolean existsByEmailId(String emailId);

  @Query("{ 'name': '?0' }")
    User findByName(String name);


}
