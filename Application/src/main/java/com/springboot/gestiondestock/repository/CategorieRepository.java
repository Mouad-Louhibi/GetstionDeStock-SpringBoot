package com.springboot.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

}
