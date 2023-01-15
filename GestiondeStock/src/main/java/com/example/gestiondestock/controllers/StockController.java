package com.example.gestiondestock.controllers;


import com.example.gestiondestock.model.stock;
import com.example.gestiondestock.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class StockController {


    @Autowired
    StockService stockService;


    @GetMapping
    public List<stock> getAllOrders() {
        return stockService.getAllOrders();
    }

    @GetMapping("/{id}")
    public stock getOrderById(@PathVariable int id) {
        return stockService.getOrderById(id);
    }

    @PostMapping("/users/{userId}")
    public stock createOrder(@PathVariable int userId, @RequestBody stock order) {
        return stockService.createOrder(userId, order);
    }

    @PutMapping("/{id}")
    public stock updateOrder(@PathVariable int id, @RequestBody stock order) {
        return stockService.updateOrder(id, order);
    }



    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        stockService.deleteOrder(id);
    }

}
