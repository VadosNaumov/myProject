package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    private Account account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.DETACH)
    private Collection<Payment> payments;

    @Override
    public int compareTo(Object o) {
        Company companySecond = (Company) o;
        return firm.compareTo(companySecond.firm);
    }

    public String getFirm() {
        return firm;
    }

    public User getUser() {
        return user;
    }

    public City getCity() {
        return city;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", user=" + user.getFirstName() + " " + user.getLastName() +
                ", city=" + city.getCityName() +
                ", country=" + city.getCountry().getState() +
                ", account=" + account.getAccountNumber() +
                ", bank=" + account.getBank().getBankName() +
                '}';
    }

}
