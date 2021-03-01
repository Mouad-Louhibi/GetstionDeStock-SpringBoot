package com.springboot.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
