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

import com.springboot.gestiondestock.entity.LigneFacture;
import com.springboot.gestiondestock.service.LigneFactureService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/ligneFacture")
public class LigneFactureController {

	@Autowired
	private LigneFactureService ligneFactureService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<LigneFacture>> getAllLigneFactures(){
		List<LigneFacture> result = ligneFactureService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LigneFacture> getLigneFactureById(@PathVariable int id) {
		LigneFacture result = ligneFactureService.findOne(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<LigneFacture> createNewLigneFacture(/*@Valid*/@RequestBody LigneFacture produit) {
		LigneFacture result = ligneFactureService.save(produit);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		ligneFactureService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
