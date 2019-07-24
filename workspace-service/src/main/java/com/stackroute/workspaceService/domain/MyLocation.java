package com.stackroute.workspaceService.domain;
import com.stackroute.kafka.domain.Category;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class MyLocation {
    @Id
    int locationId;

    String locationName;
    double latitude;
    double longitude;
    private MySpace mySpace;
    private MyAddress address;
    private List<Category> category;
    private MyDimension myDimension;


    public MyLocation() {
    }

    @Override
    public String toString() {
        return "MyLocation{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", mySpace=" + mySpace +
                ", address=" + address +
                ", category=" + category +
                ", myDimension=" + myDimension +
                '}';
    }

    public MyLocation(int locationId, String locationName, double latitude, double longitude, MySpace mySpace, MyAddress address, List<Category> category, MyDimension myDimension) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mySpace = mySpace;
        this.address = address;
        this.category = category;
        this.myDimension = myDimension;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public MySpace getMySpace() {
        return mySpace;
    }

    public void setMySpace(MySpace mySpace) {
        this.mySpace = mySpace;
    }

    public MyAddress getAddress() {
        return address;
    }

    public void setAddress(MyAddress address) {
        this.address = address;
    }

    public List<Category> getMycategory() {
        return category;
    }

    public void setMycategory(List<Category> category) {
        this.category = category;
    }

    public MyDimension getMyDimension() {
        return myDimension;
    }

    public void setMyDimension(MyDimension myDimension) {
        this.myDimension = myDimension;
    }
}
