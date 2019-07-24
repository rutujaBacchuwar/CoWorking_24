package com.stackroute.recommendation.domain;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private long id;

    @Property
    private String name;
    private String emailId;
    private int uid;

    @Relationship(type = "Booked",direction = Relationship.INCOMING)
    private List<Category> category;

    public List<Category> getCategory() {
        return category;
    }

    public User() {
    }

    public User(long id, String name, String emailId, int uid) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.uid = uid;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getUid() {
        return uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
