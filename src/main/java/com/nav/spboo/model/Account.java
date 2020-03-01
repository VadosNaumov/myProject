package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private Long accountNumber;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "bank")
    private Bank bank;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", bank=" + bank.getBankName() +
                ", company=" + company.getFirm() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return accountNumber.compareTo(((Account) o).accountNumber);
    }
}
