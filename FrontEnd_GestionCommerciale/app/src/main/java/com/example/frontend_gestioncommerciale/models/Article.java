package com.example.frontend_gestioncommerciale.models;

public class Article {

    private int articleId;

    private String label;

    private Double price;

    private Stock order;


    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Stock getOrder() {
        return order;
    }

    public void setOrder(Stock order) {
        this.order = order;
    }
}
