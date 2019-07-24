package com.stackroute.kafka.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class MySpace {

    int spaceId;
    String spaceName;
    String spaceImageUrl;
    BigDecimal totalprice;


    public MySpace() {
    }

    public MySpace(int spaceId, String spaceName, BigDecimal totalprice) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.totalprice = totalprice;

    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }


    @Override
    public String toString() {
        return "MySpace{" +
                "spaceId=" + spaceId +
                ", spaceName='" + spaceName + '\'' +
                ", totalprice=" + totalprice +
                '}';
    }
}
