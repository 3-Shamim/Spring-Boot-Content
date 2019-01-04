package com.learningstuff.completesingupandsingindemo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String password;
    private String role;

    public Users() {
    }

    public Users(Users users) {
        this.userId = users.userId;
        this.name = users.name;
        this.password = users.password;
        this.role = users.role;
    }

    public Users(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
