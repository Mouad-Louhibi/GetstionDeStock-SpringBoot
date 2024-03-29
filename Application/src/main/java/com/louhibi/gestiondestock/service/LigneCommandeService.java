package com.louhibi.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.LigneCommande;
import com.louhibi.gestiondestock.repository.LigneCommandeRepository;

@Service
public class LigneCommandeService {

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	public List<LigneCommande> findAll(){
		return ligneCommandeRepository.findAll();
	}
	
	public LigneCommande findOne(int id) {
		return ligneCommandeRepository.findById(id).get();
	}
	
	public LigneCommande save(LigneCommande ligneCommande) {
		return ligneCommandeRepository.save(ligneCommande);
	}
	
	public void delete(int id) {
		ligneCommandeRepository.deleteById(id);
	}
}
