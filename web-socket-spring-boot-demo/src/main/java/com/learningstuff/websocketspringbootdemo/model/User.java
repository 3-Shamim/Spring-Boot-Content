package com.learningstuff.websocketspringbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    private String name;
    @Enumerated
    private Role role;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Contact> contacts;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }
}
