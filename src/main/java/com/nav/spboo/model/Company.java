package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "companies")
public class Company implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firm")
    private String firm;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "director")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "location")
    private City city;

    @Override
    public int compareTo(Object o) {
        Company companySecond = (Company) o;
        return firm.compareTo(companySecond.firm);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", user=" + user.getFirstName() + " " + user.getLastName() +
                ", city=" + city.getCityName() +
                ", country=" + city.getCountry().getState() +
                '}';
    }
}
