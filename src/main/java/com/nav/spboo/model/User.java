package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.DETACH)
    private Collection<Mail> mails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.DETACH)
    private Collection<Company> companies;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Object o) {
        User userSecond = (User) o;
        return firstName.compareTo(userSecond.firstName);
    }
}
