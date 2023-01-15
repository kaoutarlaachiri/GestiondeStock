package com.example.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("user")
    private List<stock> orders;

    public Utilisateur(){

    }

    public Utilisateur (String username, String emailId, String password) {
        super();
        this.username=username;
        this.emailId=emailId;
        this.password=password;
    }

    public long getId() {
        return userId;
    }
    public void setId(long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<stock> getOrders() {
        return orders;
    }

    public void setOrders(List<stock> orders) {
        this.orders = orders;
    }

}
