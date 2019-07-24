package com.stackroute.loginservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1 {
    @Id
    private long uid;
    private String name;
    private String password;
    private String role="Client";

}














