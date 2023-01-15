package com.example.gestiondestock.services;

import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.model.stock;
import com.example.gestiondestock.repository.StockRepository;
import com.example.gestiondestock.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public List<stock> getAllOrders() {
        return stockRepository.findAll();
    }

    public stock getOrderById(int id) {
        return stockRepository.findById(id).orElse(null);
    }

    public stock createOrder(int userId, stock order) {
        Utilisateur user;
        user = utilisateurRepository.findById(userId).orElse(null);
        if (user != null) {
            order.setUser(user);
            return stockRepository.save(order);
        } else {
            return null;
        }
    }

    public stock updateOrder(int id, stock order) {
        stock existingOrder = stockRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setOrder(order.getOrder());
            return stockRepository.save(existingOrder);
        } else {
            return null;
        }

    }

    public void deleteOrder(int id) {
        stockRepository.deleteById(id);
    }
}
