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

import com.louhibi.gestiondestock.entity.Produit;
import com.louhibi.gestiondestock.service.ProduitService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Produit>> getAllProduits(){
		List<Produit> result = produitService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable int id) {
		Produit result = produitService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Produit> createNewProduit(/*@Valid*/@RequestBody Produit produit) {
		Produit result = produitService.save(produit);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		produitService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
