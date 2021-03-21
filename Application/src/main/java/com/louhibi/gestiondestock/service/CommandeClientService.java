package com.louhibi.gestiondestock.service;

import java.util.List;

import com.louhibi.gestiondestock.entity.CommandeClient;
import com.louhibi.gestiondestock.entity.LigneCommande;
import com.louhibi.gestiondestock.repository.CommandeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.Commande;
import com.louhibi.gestiondestock.repository.CommandeRepository;

@Service
public class CommandeClientService {

	@Autowired
	private CommandeClientRepository commandeClientRepository;
	
	public List<CommandeClient> findAll(){
		return commandeClientRepository.findAll();
	}
	
	public CommandeClient findOne(int id) {
		return commandeClientRepository.findById(id).get();
	}
	
	public CommandeClient save(CommandeClient commande) {
		return commandeClientRepository.save(commande);
	}
	
	public void delete(int id) {
		commandeClientRepository.deleteById(id);
	}
}
