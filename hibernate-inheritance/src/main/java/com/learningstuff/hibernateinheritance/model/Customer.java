package com.learningstuff.hibernateinheritance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Customer extends User {

    private String name;
    private String address;
    private String phone;

}
