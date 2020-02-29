package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state")
    private String state;

    @Column(name = "currency_code")
    private Integer currencyCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.DETACH)
    private Collection<City> cities;

    public Long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public Collection<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", currencyCode=" + currencyCode +
                ", cities=" + cities +
                '}';
    }
}
