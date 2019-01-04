package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StudentDetails {
    @Id
    private int id;
    @Embedded
    private Name name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name = "Registration",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "courseCode")})
    private Set<Course> courseSet;

    public StudentDetails() {
        courseSet = new HashSet<>();
    }

    public StudentDetails(int id, Name name, String email, Sex sex, Address address) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", address=" + address +
                ", courseSet=" + courseSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentDetails that = (StudentDetails) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
