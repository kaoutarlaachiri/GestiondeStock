package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article,Integer> {
    @Override
    List<Article> findAll();
}
