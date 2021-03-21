package com.louhibi.gestiondestock.controller;

import java.util.List;

import com.louhibi.gestiondestock.entity.CommandeClient;
import com.louhibi.gestiondestock.entity.LigneCommande;
import com.louhibi.gestiondestock.entity.LigneCommandeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.louhibi.gestiondestock.entity.Commande;
import com.louhibi.gestiondestock.service.CommandeClientService;

@Controller
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/commandeClient")
public class CommandeClientController {

	@Autowired
	private CommandeClientService commandeClientService;

	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<CommandeClient>> getAllCommandes(){
		List<CommandeClient> result = commandeClientService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable int id) {
		Commande result = commandeClientService.findOne(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}/details")
	public ResponseEntity<List<LigneCommandeClient>> getLignesCommande(@PathVariable int id) {
		List<LigneCommandeClient> result = commandeClientService.findOne(id).getLigneCommandeClient();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping(value = {"", "/"})
	public ResponseEntity<Commande> createNewCommande(/*@Valid*/@RequestBody CommandeClient commande) {
		Commande result = commandeClientService.save(commande);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		commandeClientService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
