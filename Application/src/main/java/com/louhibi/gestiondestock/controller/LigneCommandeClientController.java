package com.louhibi.gestiondestock.controller;

import java.util.List;

import com.louhibi.gestiondestock.entity.LigneCommandeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.louhibi.gestiondestock.entity.LigneCommande;
import com.louhibi.gestiondestock.service.LigneCommandeClientService;

@Controller
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/ligneCommandeClient")
public class LigneCommandeClientController {

	@Autowired
	private LigneCommandeClientService ligneCommandeClientService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<LigneCommandeClient>> getAllLigneCommandeClients(){
		List<LigneCommandeClient> result = ligneCommandeClientService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LigneCommandeClient> getLigneCommandeClientById(@PathVariable int id) {
		LigneCommandeClient result = ligneCommandeClientService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<LigneCommandeClient> createNewLigneCommandeClient(/*@Valid*/@RequestBody LigneCommandeClient ligneCommandeClient) {
		LigneCommandeClient result = ligneCommandeClientService.save(ligneCommandeClient);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		ligneCommandeClientService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}