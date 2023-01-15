package com.example.gestiondestock.controllers;

import com.example.gestiondestock.model.Article;
import com.example.gestiondestock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Article> getAllProducts() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getProductById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @PostMapping("/orders/{orderId}")
    public Article createProduct(@PathVariable int orderId, @RequestBody Article article) {
        return articleService.createArticle(orderId,article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable int id, @RequestBody Article article) {
        return articleService.updateArticle(id,article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleService.deleteArticle(id);
    }

}
