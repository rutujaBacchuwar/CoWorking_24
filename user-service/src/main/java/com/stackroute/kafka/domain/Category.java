package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Arrays;

@Data
public class Category {

    @Id
    int categoryId;
    String categoryName;
    BigDecimal price;
    String[] additionalAmenities;

    double hourlyPrice;
    double monthlyPrice;
    double dailyPrice;
    String status="Available";

    public Category(int categoryId, String categoryName, BigDecimal price, String[] additionalAmenities, double hourlyPrice, double monthlyPrice, double dailyPrice, String status, int capacity, Dimension dimension) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
        this.additionalAmenities = additionalAmenities;
        this.hourlyPrice = hourlyPrice;
        this.monthlyPrice = monthlyPrice;
        this.dailyPrice = dailyPrice;
        this.status = status;
        this.capacity = capacity;
        this.dimension = dimension;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAdditionalAmenities(String[] additionalAmenities) {
        this.additionalAmenities = additionalAmenities;
    }

    int capacity;


    private Dimension dimension;

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Category() {
    }



    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String[] getAdditionalAmenities() {
        return additionalAmenities;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", additionalAmenities=" + Arrays.toString(additionalAmenities) +
                ", hourlyPrice=" + hourlyPrice +
                ", monthlyPrice=" + monthlyPrice +
                ", dailyPrice=" + dailyPrice +
                ", status='" + status + '\'' +
                ", capacity=" + capacity +
                ", dimension=" + dimension +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
