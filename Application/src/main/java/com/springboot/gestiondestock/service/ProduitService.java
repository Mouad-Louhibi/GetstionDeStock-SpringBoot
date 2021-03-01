package com.springboot.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gestiondestock.entity.Produit;
import com.springboot.gestiondestock.repository.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	public List<Produit> findAll(){
		return produitRepository.findAll();
	}
	
	public Produit findOne(int id) {
		return produitRepository.findById(id).get();
	}
	
	public Produit save(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public void delete(int id) {
		produitRepository.deleteById(id);
	}
}
