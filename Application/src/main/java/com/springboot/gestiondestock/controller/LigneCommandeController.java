package com.springboot.gestiondestock.controller;

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

import com.springboot.gestiondestock.entity.LigneCommande;
import com.springboot.gestiondestock.service.LigneCommandeService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/ligneCommande")
public class LigneCommandeController {

	@Autowired
	private LigneCommandeService ligneCommandeService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<LigneCommande>> getAllLigneCommandes(){
		List<LigneCommande> result = ligneCommandeService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LigneCommande> getLigneCommandeById(@PathVariable int id) {
		LigneCommande result = ligneCommandeService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<LigneCommande> createNewProduit(/*@Valid*/@RequestBody LigneCommande ligneCommande) {
		LigneCommande result = ligneCommandeService.save(ligneCommande);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		ligneCommandeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
