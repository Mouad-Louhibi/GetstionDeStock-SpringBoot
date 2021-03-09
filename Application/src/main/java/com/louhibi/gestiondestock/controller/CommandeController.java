package com.louhibi.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louhibi.gestiondestock.entity.Commande;
import com.louhibi.gestiondestock.service.CommandeService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/commande")
public class CommandeController {

	@Autowired
	private CommandeService commandeService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Commande>> getAllCommandes(){
		List<Commande> result = commandeService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable int id) {
		Commande result = commandeService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Commande> createNewCommande(/*@Valid*/@RequestBody Commande commande) {
		Commande result = commandeService.save(commande);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		commandeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
