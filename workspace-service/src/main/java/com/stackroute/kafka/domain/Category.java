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
        // BigDecimal price;
        String[] additionalAmenities;
        double hourlyPrice;
        double monthlyPrice;
        double dailyPrice;
        int capacity;
        String status="Available";


        private Dimension dimension;

        public Dimension getDimension() {
            return dimension;
        }

        public void setDimension(Dimension dimension) {
            this.dimension = dimension;
        }

        public Category() {
        }

        public Category(int categoryId, String categoryName, BigDecimal price, String[] additionalAmenities) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            // this.price = price;
            this.additionalAmenities = additionalAmenities;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public void setAdditionalAmenities(String[] additionalAmenities) {
            this.additionalAmenities = additionalAmenities;
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

        public int getCategoryId() {
            return categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

//    public BigDecimal getPrice() {
//        return price;
//    }

        public String[] getAdditionalAmenities() {
            return additionalAmenities;
        }


    }

