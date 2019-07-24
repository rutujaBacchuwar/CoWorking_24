package com.stackroute.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Document
@AllArgsConstructor
@ToString
public class CardDetails {

    private String cardName;
    private long cardNumber;
    private int expMonth;
    private int expYear;
    private int cvv;
    private BigDecimal price;

    public CardDetails() {
    }


}
