package com.louhibi.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louhibi.gestiondestock.entity.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer>{

}
