package com.springboot.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer>{

}
