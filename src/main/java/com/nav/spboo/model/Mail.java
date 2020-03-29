package com.nav.spboo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mails")
public class Mail implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post")
    private String mailName;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public String getMailName() {
        return mailName;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", mail='" + mailName +
                ", user=" + user.getFirstName() + " " + user.getLastName() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Mail mailSecond = (Mail) o;
        return mailName.compareTo(mailSecond.mailName);
    }
}
