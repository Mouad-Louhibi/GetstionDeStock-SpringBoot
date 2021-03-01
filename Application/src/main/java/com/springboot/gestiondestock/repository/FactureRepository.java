package com.springboot.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Integer>{

}
