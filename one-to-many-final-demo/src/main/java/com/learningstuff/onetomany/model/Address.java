package com.learningstuff.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "user")
@Entity
public class Address {

    @Id
    private int id;
    private String addressName;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Address(int id, String addressName) {
        this.id = id;
        this.addressName = addressName;
    }
}
