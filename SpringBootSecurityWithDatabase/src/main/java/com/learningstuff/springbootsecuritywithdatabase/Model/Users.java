package com.learningstuff.springbootsecuritywithdatabase.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles;

    public Users() {

    }

    public Users(Users users) {
        this.id = users.getId();
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.name = users.getName();
        this.roles = users.getRoles();
    }

    public Users(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
