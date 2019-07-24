package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.List;

@NodeEntity
public class Category {

    @GraphId
    private long categoryId;

    @Property
    private String categoryName;
    private  double price;
    Space space;

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Category() {
    }

    @Relationship(type = "Located", direction = Relationship.INCOMING)
    private List<Location> locations;

    public Category(long categoryId, String categoryName,double price) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", space=" + space +
                ", locations=" + locations +
                '}';
    }
}


