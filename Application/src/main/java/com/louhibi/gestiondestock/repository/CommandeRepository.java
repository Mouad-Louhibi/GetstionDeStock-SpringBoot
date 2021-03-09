package com.louhibi.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louhibi.gestiondestock.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
