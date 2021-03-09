package com.louhibi.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.LigneFacture;
import com.louhibi.gestiondestock.repository.LigneFactureRepository;

@Service
public class LigneFactureService {

	@Autowired
	private LigneFactureRepository ligneFactureRepository;
	
	public List<LigneFacture> findAll(){
		return ligneFactureRepository.findAll();
	}
	
	public LigneFacture findOne(int id) {
		return ligneFactureRepository.findById(id).get();
	}
	
	public LigneFacture save(LigneFacture ligneFacture) {
		return ligneFactureRepository.save(ligneFacture);
	}
	
	public void delete(int id) {
		ligneFactureRepository.deleteById(id);
	}
}
