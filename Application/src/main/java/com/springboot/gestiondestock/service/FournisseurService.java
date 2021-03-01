package com.springboot.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gestiondestock.entity.Fournisseur;
import com.springboot.gestiondestock.repository.FournisseurRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	public List<Fournisseur> findAll(){
		return fournisseurRepository.findAll();
	}
	
	public Fournisseur findOne(int id) {
		return fournisseurRepository.findById(id).get();
	}
	
	public Fournisseur save(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}
	
	public void delete(int id) {
		fournisseurRepository.deleteById(id);
	}
}
