package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "countries")
public class Country implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state")
    private String state;

    @Column(name = "currency_code")
    private Integer currencyCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.DETACH)
    private Collection<City> cities;

    public String getState() {
        return state;
    }

    @Override
    public int compareTo(Object o) {
        Country countrySecond = (Country) o;
        return state.compareTo(countrySecond.state);
    }
}
