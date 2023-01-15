package com.example.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.persistence.Entity;

import java.util.List;
import java.util.Optional;
@Entity
@Table(name = "orders")
public class stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "orders")
    private String order;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Utilisateur user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("order")
    public List<Article> articles;




    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrder() {
        return order;
    }


    public void setOrder(String order) {
        this.order = order;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Article> getProducts() {
        return articles;
    }

    public void setProducts(List<Article> products) {
        this.articles = products;
    }







}
