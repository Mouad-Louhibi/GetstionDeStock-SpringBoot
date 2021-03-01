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

import com.springboot.gestiondestock.entity.Fournisseur;
import com.springboot.gestiondestock.service.FournisseurService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/fournisseur")
public class FournisseurController {
	
	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Fournisseur>> getAllFournisseurs(){
		List<Fournisseur> result = fournisseurService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable int id) {
		Fournisseur result = fournisseurService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Fournisseur> createNewFournisseur(/*@Valid*/@RequestBody Fournisseur fournisseur) {
		Fournisseur result = fournisseurService.save(fournisseur);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		fournisseurService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
