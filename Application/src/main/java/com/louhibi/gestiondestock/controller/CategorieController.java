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

import com.louhibi.gestiondestock.entity.Categorie;
import com.louhibi.gestiondestock.service.CategorieService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/categorie")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Categorie>> getAllCategories(){
		List<Categorie> result = categorieService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable int id) {
		Categorie result = categorieService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Categorie> createNewCategorie(/*@Valid*/@RequestBody Categorie categorie) {
		Categorie result = categorieService.save(categorie);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		categorieService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
