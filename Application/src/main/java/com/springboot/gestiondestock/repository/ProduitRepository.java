package com.springboot.gestiondestock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	
	List<Produit> getProduitsSortedByName();
}
