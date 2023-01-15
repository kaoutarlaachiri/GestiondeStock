package com.example.gestiondestock.services;

import com.example.gestiondestock.model.Article;
import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.model.stock;
import com.example.gestiondestock.repository.ArticleRepository;
import com.example.gestiondestock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    StockRepository stockRepository;




    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }




    public Article getArticleById(int id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article createArticle(int orderId, Article article) {
        stock order;
        order = stockRepository.findById(orderId).orElse(null);
        if (order != null) {
            article.setOrder(order);
            return articleRepository.save(article);
        } else {
            return null;
        }
    }




    public Article updateArticle(int id, Article article) {
        Article existingArticle = articleRepository.findById(id).orElse(null);
        if (existingArticle != null) {
            existingArticle.setLabel(article.getLabel());
            existingArticle.setPrice(article.getPrice());
            return articleRepository.save(existingArticle);
        } else {
            return null;
        }

    }

    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

}
