package com.learningstuff.springsecuritywithjwtwithdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private int roleId;
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
