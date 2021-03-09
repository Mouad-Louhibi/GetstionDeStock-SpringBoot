package com.louhibi.gestiondestock.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louhibi.gestiondestock.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	
	// List<Produit> getProduitsSortedByName();
}
