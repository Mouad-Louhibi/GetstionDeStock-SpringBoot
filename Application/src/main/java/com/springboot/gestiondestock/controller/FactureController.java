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

import com.springboot.gestiondestock.entity.Facture;
import com.springboot.gestiondestock.service.FactureService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/facture")
public class FactureController {

	@Autowired
	private FactureService factureService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Facture>> getAllFactures(){
		List<Facture> result = factureService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Facture> getFactureById(@PathVariable int id) {
		Facture result = factureService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Facture> createNewFacture(/*@Valid*/@RequestBody Facture facture) {
		Facture result = factureService.save(facture);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		factureService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
