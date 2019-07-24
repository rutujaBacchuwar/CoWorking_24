package com.stackroute.kafka.domain;

import java.util.Date;
import java.util.List;

public class MyBookings {
    String spaceName;
    String categoryName;
    String locationName;
    double price;
    Date startDate;
    Date endDate;
    int bookingId;
    String name;

    public MyBookings(String spaceName, String categoryName, String locationName, double price, Date startDate, Date endDate, int bookingId, String name, String categoryStatus) {
        this.spaceName = spaceName;
        this.categoryName = categoryName;
        this.locationName = locationName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingId = bookingId;
        this.name = name;
        this.categoryStatus = categoryStatus;

    }

    String categoryStatus;

    public MyBookings(String spaceName, String categoryName, String locationName, double price, Date startDate, Date endDate, int bookingId, String name) {
        this.spaceName = spaceName;
        this.categoryName = categoryName;
        this.locationName = locationName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingId = bookingId;
        this.name = name;

    }

    public MyBookings() {
    }




    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyBookings{" +
                "spaceName='" + spaceName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", locationName='" + locationName + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bookingId=" + bookingId +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}
