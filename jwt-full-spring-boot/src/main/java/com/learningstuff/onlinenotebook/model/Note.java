package com.learningstuff.onlinenotebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "NOTE")
public class Note {

    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String note;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public Note(String name, String note) {
        this.name = name;
        this.note = note;
    }
}
