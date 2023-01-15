package com.example.gestiondestock.repository;


import com.example.gestiondestock.model.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StockRepository extends CrudRepository<stock, Integer> {
    @Override
     List<stock> findAll();
}
