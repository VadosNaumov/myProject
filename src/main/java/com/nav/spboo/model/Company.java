package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firm")
    private String firm;
}
