package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Booking {

    private MyUser myUser;
    Date startDate;
    Date endDate;

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
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

    public Booking(MyUser myUser, Date startDate, Date endDate) {
        this.myUser = myUser;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Booking() {
        super();
    }
}
