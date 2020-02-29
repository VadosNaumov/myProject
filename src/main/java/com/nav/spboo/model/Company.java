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

    @Override
    public int compareTo(Object o) {
        Company companySecond = (Company) o;
        return firm.compareTo(companySecond.firm);
    }
}
