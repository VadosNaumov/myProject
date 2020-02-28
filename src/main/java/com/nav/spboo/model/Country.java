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
    private String currencyCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
    private Collection<City> cities;
}
