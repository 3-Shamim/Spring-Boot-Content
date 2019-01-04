package com.learningstuff.librarymanagementsystem.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer Id;
    @NotNull
    @Size(min = 1, message = "Field must not be empty!")
    private String name;
    private boolean availability;
    @NotNull(message = "Field must not be empty!")
    @Min(value = 0)
    private Integer quantity;

    public Book() {
    }

    public Book(Integer id, String name, boolean availability, Integer quantity) {
        this();
        Id = id;
        this.name = name;
        this.availability = availability;
        this.quantity = quantity;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
