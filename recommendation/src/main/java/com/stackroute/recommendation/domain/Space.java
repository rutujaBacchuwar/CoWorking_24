package com.stackroute.recommendation.domain;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collection;
import java.util.List;

@NodeEntity
public class Space {

    @GraphId
    private long spaceId;

    @Property
    private String spaceName;

    private String spaceImageUrl;

    @Relationship(type = "Contains",direction = Relationship.INCOMING)
    private List<Category> category;

    @Relationship(type = "Located",direction = Relationship.INCOMING)
    private List<Location> locations;


    public Space() {
    }

    public Space(long spaceId, String spaceName,String spaceImageUrl) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.spaceImageUrl=spaceImageUrl;
    }

    public String getSpaceImageUrl() {
        return spaceImageUrl;
    }

    public void setSpaceImageUrl(String spaceImageUrl) {
        this.spaceImageUrl = spaceImageUrl;
    }

    public long getSpaceId() {
        return spaceId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceId(long spaceId) {
        this.spaceId = spaceId;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public String toString() {
        return "Space{" +
                "spaceId=" + spaceId +
                ", spaceName='" + spaceName + '\'' +
                ", category=" + category +
                ", locations=" + locations +
                ", spaceImageUrl=" + spaceImageUrl +
                '}';
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Category> getCategory() {
        return category;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
