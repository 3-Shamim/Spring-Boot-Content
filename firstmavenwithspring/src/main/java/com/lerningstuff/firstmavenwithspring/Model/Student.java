package com.lerningstuff.firstmavenwithspring.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
    @NotNull
    @Size(min = 1,message = "Field must not be empty!")
    private String name;
    @NotNull(message = "Field must not be empty!")
    @Min(0)
    private Integer Id;

    public Student() {
    }

    public Student(String name, Integer id) {
        this.name = name;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
