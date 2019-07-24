package com.stackroute.workspaceService.domain;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Document
@Data
@Component
public class MyCategory {

    @Id
    int categoryId;
    String categoryName;
    double price;
    String[] additionalAmenities;
    private MySpace mySpace;
    private MyAddress myaddress;
    private MyDimension myDimension;
    private MyLocation mylocation;


    public MyCategory() {
    }

    public MyCategory(int categoryId, String categoryName, double price, String[] additionalAmenities, MySpace mySpace, MyAddress myaddress, MyDimension myDimension, MyLocation mylocation) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
        this.additionalAmenities = additionalAmenities;
        this.mySpace = mySpace;
        this.myaddress = myaddress;
        this.myDimension = myDimension;
        this.mylocation = mylocation;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String[] getAdditionalAmenities() {
        return additionalAmenities;
    }

    public void setAdditionalAmenities(String[] additionalAmenities) {
        this.additionalAmenities = additionalAmenities;
    }

    public MySpace getMySpace() {
        return mySpace;
    }

    public void setMySpace(MySpace mySpace) {
        this.mySpace = mySpace;
    }

    public MyAddress getMyAddress() {
        return myaddress;
    }

    public void setMyAddress(MyAddress myaddress) {
        this.myaddress = myaddress;
    }

    public MyDimension getMyDimension() {
        return myDimension;
    }

    public void setMyDimension(MyDimension myDimension) {
        this.myDimension = myDimension;
    }

    public MyLocation getLocation() {
        return mylocation;
    }

    public void setLocation(MyLocation location) {
        this.mylocation = location;
    }

    @Override
    public String toString() {
        return "MyCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", additionalAmenities=" + Arrays.toString(additionalAmenities) +
                ", mySpace=" + mySpace +
                ", myaddress=" + myaddress +
                ", myDimension=" + myDimension +
                ", mylocation=" + mylocation +
                '}';
    }
}

