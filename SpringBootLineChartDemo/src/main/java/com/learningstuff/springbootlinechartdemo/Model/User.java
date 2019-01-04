package com.learningstuff.springbootlinechartdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private int facebook;
    private int twitter;
    private int google_plus;
}
