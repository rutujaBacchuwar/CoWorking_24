package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User) WHERE u.name={name} RETURN u")
    public User getNode(@Param("name") String name);

    @Query("MATCH (n:User) RETURN n")
    public Collection<User> getAllUsers();

    @Query("CREATE (u:User) SET u.id={id},u.name={name},u.emailId={email},u.uid={uid}")
    public User createNode(long id, String name,String email,int uid);

    @Query("MATCH (n:User) WHERE n.id={userId} DETACH DELETE n RETURN 'node deleted' ")
    public User deleteNode(long userId);

    @Query("MATCH (User) DETACH DELETE User")
    public User deleteAllNodes();

    @Query("MATCH (n:User) WHERE n.id={id} SET n.name={name},u.emailId={email},u.uid={uid} RETURN n")
    public User updateNode(long id, String name,String email,int uid);


}
