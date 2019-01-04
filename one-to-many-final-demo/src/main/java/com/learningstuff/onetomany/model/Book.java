package com.learningstuff.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "user")
@Entity
public class Book {

    @Id
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Book(int id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }
}
