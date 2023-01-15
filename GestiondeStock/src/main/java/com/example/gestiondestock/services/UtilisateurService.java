package com.example.gestiondestock.services;

import com.example.gestiondestock.configurations.SecurityConfig;
import com.example.gestiondestock.model.Utilisateur;
import com.example.gestiondestock.model.stock;
import com.example.gestiondestock.repository.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository userRepository;
    @Autowired
    SecurityConfig securityConfig;

    public List<Utilisateur> getAllUsers() {

        return userRepository.findAll();
    }

    public Utilisateur getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public Utilisateur createUser(Utilisateur user) {
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Utilisateur updateUser(int id, Utilisateur user) {
        Utilisateur existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Utilisateur authenticateUser(String username, String password) {
        Utilisateur user = userRepository.findByUsername(username);
        if (user != null && securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }


}
