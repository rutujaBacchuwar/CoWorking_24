package com.stackroute.kafka.domain;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MyCategory {


    int categoryId;
    String categoryName;
    double price;
    private MyLocation myLocation;
    private MySpace mySpace;
    String status="Available";
    public MyCategory() {
    }

    public MyCategory(int categoryId, String categoryName, double price, MyLocation myLocation, MySpace mySpace, String status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
        this.myLocation = myLocation;
        this.mySpace = mySpace;
        this.status = status;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public MyLocation getMyLocation() {
        return myLocation;
    }

    public void setMyLocation(MyLocation myLocation) {
        this.myLocation = myLocation;
    }

    public MySpace getMySpace() {
        return mySpace;
    }

    public void setMySpace(MySpace mySpace) {
        this.mySpace = mySpace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "MyCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", myLocation=" + myLocation +
                ", mySpace=" + mySpace +
                ", status='" + status + '\'' +
                '}';
    }
}
