package com.louhibi.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.Categorie;
import com.louhibi.gestiondestock.repository.CategorieRepository;

@Service
public class CategorieService {

	@Autowired
	private CategorieRepository categorietRepository;
	
	public List<Categorie> findAll(){
		return categorietRepository.findAll();
	}
	
	public Categorie findOne(int id) {
		return categorietRepository.findById(id).get();
	}
	
	public Categorie save(Categorie categorie) {
		return categorietRepository.save(categorie);
	}
	
	public void delete(int id) {
		categorietRepository.deleteById(id);
	}
}
