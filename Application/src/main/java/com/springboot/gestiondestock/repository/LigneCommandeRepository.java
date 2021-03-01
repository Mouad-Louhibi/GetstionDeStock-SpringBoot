package com.springboot.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer>{

}
