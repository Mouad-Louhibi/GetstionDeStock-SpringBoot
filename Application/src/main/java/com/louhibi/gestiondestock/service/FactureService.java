package com.louhibi.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.Facture;
import com.louhibi.gestiondestock.repository.FactureRepository;

@Service
public class FactureService {

	@Autowired
	private FactureRepository factureRepository;
	
	public List<Facture> findAll(){
		return factureRepository.findAll();
	}
	
	public Facture findOne(int id) {
		return factureRepository.findById(id).get();
	}
	
	public Facture save(Facture facture) {
		return factureRepository.save(facture);
	}
	
	public void delete(int id) {
		factureRepository.deleteById(id);
	}
}
