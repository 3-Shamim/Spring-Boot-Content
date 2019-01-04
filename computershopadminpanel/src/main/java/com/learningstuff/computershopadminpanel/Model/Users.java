package com.learningstuff.computershopadminpanel.Model;

import lombok.*;

@Data
public class Users {
    private Integer id;
    private String userName;
    private String password;
    private String role;
    private String address;
    private String email;
    private String number;
    private byte[] image;

}
