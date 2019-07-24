package com.stackroute.workspaceService.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
public class MySpace {
    @Id
    int spaceId;
    String spaceName;
    String spaceImageUrl;
    BigDecimal totalprice;

    public MySpace() {
    }

    public MySpace(int spaceId, String spaceName, String spaceImageUrl, BigDecimal totalprice) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.spaceImageUrl = spaceImageUrl;
        this.totalprice = totalprice;
    }


    @Override
    public String toString() {
        return "Space{" +
                "spaceId=" + spaceId +
                ", spaceName='" + spaceName + '\'' +
                ", spaceImageUrl='" + spaceImageUrl + '\'' +
                ", totalprice=" + totalprice +
                '}';
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

    public String getSpaceImageUrl() {
        return spaceImageUrl;
    }

    public void setSpaceImageUrl(String spaceImageUrl) {
        this.spaceImageUrl = spaceImageUrl;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }
}

