package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "banks")
public class Bank implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "bank", fetch = FetchType.LAZY)
    private Collection<Account> accounts;

    public String getBankName() {
        return bankName;
    }

    @Override
    public int compareTo(Object o) {
        return bankName.compareTo(((Bank) o).bankName);
    }
}
