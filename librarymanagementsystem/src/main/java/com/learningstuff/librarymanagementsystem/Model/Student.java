package com.learningstuff.librarymanagementsystem.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer Id;
    @NotNull
    @Size(min = 1, message = "Field must not be empty!")
    private String name;
    @NotNull
    @Size(min = 1, message = "Field must not be empty!")
    private String sex;
    @NotNull
    @Size(min = 1, message = "Field must not be empty!")
    private String address;

    public Student() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
