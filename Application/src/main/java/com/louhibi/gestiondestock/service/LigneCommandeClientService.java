package com.louhibi.gestiondestock.service;

import java.util.List;

import com.louhibi.gestiondestock.entity.LigneCommandeClient;
import com.louhibi.gestiondestock.repository.LigneCommandeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.LigneCommande;

@Service
public class LigneCommandeClientService {

	@Autowired
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	
	public List<LigneCommandeClient> findAll(){
		return ligneCommandeClientRepository.findAll();
	}
	
	public LigneCommandeClient findOne(int id) {
		return ligneCommandeClientRepository.findById(id).get();
	}
	
	public LigneCommandeClient save(LigneCommandeClient ligneCommandeClient) {
		return ligneCommandeClientRepository.save(ligneCommandeClient);
	}

	public List<LigneCommandeClient> findAllByCommandeID(int id){
		return ligneCommandeClientRepository.findLigneCommandeClientsByCommandeClient_Id(id);
	}
	public void delete(int id) {
		ligneCommandeClientRepository.deleteById(id);
	}
}
