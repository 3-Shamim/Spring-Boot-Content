package com.learningstuff.onlinenotebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(generator = "native", strategy =  GenerationType.SEQUENCE)
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String role;

    public Role(String role) {
        this.role = role;
    }
}
