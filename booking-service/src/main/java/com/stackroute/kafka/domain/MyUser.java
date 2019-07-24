package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MyUser {

    @Id
    private int uid;
    private String name;
    private String emailId;
    private MyCategory myCategory;


    public MyUser() {
    }

    public MyUser(int uid, String name, String emailId, MyCategory myCategory) {
        this.uid = uid;
        this.name = name;
        this.emailId = emailId;
        this.myCategory = myCategory;

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public MyCategory getMyCategory() {
        return myCategory;
    }

    public void setMyCategory(MyCategory myCategory) {
        this.myCategory = myCategory;
    }



    @Override
    public String toString() {
        return "MyUser{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", myCategory=" + myCategory +

                '}';
    }
}
