package com.learningstuff.springsecuritymothod.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private int id;
    private String bookName;
    private User user;

}
