package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Long getId() {
        return id;
    }

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
}
