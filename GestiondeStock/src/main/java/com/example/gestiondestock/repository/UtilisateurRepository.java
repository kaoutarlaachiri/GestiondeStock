package com.example.gestiondestock.repository;

import com.example.gestiondestock.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Integer> {
    @Override
    List<Utilisateur> findAll();
    Utilisateur findByUsername(String username);
}
