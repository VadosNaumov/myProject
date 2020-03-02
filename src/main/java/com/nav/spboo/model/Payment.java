package com.nav.spboo.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "to_company")
    private Company company;

    @Override
    public int compareTo(Object o) {
        Payment paySecond = (Payment) o;
        return date.compareTo(paySecond.date);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", company=" + company.getFirm() +
                ", user=" + company.getUser().getFirstName() + " " + company.getUser().getLastName() +
                ", city=" + company.getCity().getCityName() +
                ", country=" + company.getCity().getCountry().getState() +
                ", account=" + company.getAccount().getAccountNumber() +
                ", bank=" + company.getAccount().getBank().getBankName() +
                '}';
    }
}
