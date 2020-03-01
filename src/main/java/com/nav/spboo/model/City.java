package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "cities")
public class City implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city", cascade = CascadeType.DETACH)
    private Collection<Company> companies;

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", country=" + country.getState() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        City citySecond = (City) o;
        return cityName.compareTo(citySecond.cityName);
    }
}
