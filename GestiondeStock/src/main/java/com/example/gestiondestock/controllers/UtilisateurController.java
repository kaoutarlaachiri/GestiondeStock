package com.example.gestiondestock.controllers;


import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gestiondestock.services.UtilisateurService;
import java.util.List;

@RestController
@RequestMapping("/Utilisateurs")
public class UtilisateurController {


    @Autowired
    UtilisateurService userService;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Utilisateur getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Utilisateur createUser(@RequestBody Utilisateur user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable int id, @RequestBody Utilisateur user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public Utilisateur login(@RequestBody Utilisateur user) {
        return userService.authenticateUser(user.getUsername(), user.getPassword());
    }


}
