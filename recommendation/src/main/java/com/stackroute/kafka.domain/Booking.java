package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;



@Data
public class Booking {


    private boolean status;
    private MyUser myUser;

    public Booking() {
    }

    public Booking( boolean status, MyUser myUser) {

        this.status = status;

        this.myUser = myUser;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "status=" + status +
                ", myUser=" + myUser +
                '}';
    }
}

