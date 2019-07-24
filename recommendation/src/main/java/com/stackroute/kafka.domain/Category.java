package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Arrays;

@Data
public class Category {

    @Id
    int categoryId;
    String categoryName;
    double price;
    String[] additionalAmenities;
    double hourlyPrice;
    double dailyPrice;
    double monthlyPrice;
    int capacity;


    private Dimension dimension;

    public Category(int categoryId, String categoryName, double price, String[] additionalAmenities, double hourlyPrice, double dailyPrice, double monthlyPrice, int capacity, Dimension dimension) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.price = price;
        this.additionalAmenities = additionalAmenities;
        this.hourlyPrice = hourlyPrice;
        this.dailyPrice = dailyPrice;
        this.monthlyPrice = monthlyPrice;
        this.capacity = capacity;
        this.dimension = dimension;
    }

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

    public double getPrice() {
        return price;
    }

    public String[] getAdditionalAmenities() {
        return additionalAmenities;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                ", additionalAmenities=" + Arrays.toString(additionalAmenities) +
                ", hourlyPrice=" + hourlyPrice +
                ", dailyPrice=" + dailyPrice +
                ", monthlyPrice=" + monthlyPrice +
                ", capacity=" + capacity +
                ", dimension=" + dimension +
                '}';
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
