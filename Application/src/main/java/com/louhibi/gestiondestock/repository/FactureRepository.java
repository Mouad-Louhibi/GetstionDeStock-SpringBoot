package com.louhibi.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louhibi.gestiondestock.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Integer>{

}
