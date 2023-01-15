package com.example.gestiondestock.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.awt.*;
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int articleId;

    private String label;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    //@JsonIgnoreProperties("products")
    private stock order;


    public Article(){

    }

    public Article(String label, Double price, stock order){
        this.label=label;
        this.price=price;
        this.order=order;

    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public stock getOrder() {
        return order;
    }

    public void setOrder(stock order) {
        this.order = order;
    }


}
