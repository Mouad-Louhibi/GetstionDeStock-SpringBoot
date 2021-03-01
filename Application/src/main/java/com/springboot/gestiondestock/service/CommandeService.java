package com.springboot.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gestiondestock.entity.Commande;
import com.springboot.gestiondestock.repository.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	
	public List<Commande> findAll(){
		return commandeRepository.findAll();
	}
	
	public Commande findOne(int id) {
		return commandeRepository.findById(id).get();
	}
	
	public Commande save(Commande commande) {
		return commandeRepository.save(commande);
	}
	
	public void delete(int id) {
		commandeRepository.deleteById(id);
	}
}
