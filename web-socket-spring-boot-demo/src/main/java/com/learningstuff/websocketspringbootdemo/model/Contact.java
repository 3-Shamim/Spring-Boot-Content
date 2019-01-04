package com.learningstuff.websocketspringbootdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "user")
public class Contact {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDateTime time;
    private boolean seen;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    public Contact(String name, String email, String subject, String message, LocalDateTime time, boolean seen) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.time = time;
        this.seen = seen;
    }
}
