package com.louhibi.gestiondestock.controller;

import java.util.List;
import java.util.Optional;

import com.louhibi.gestiondestock.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.louhibi.gestiondestock.entity.Fournisseur;
import com.louhibi.gestiondestock.service.FournisseurService;

@Controller
@RestController
@CrossOrigin
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

	@PutMapping (value = {"", "/{id}"})
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable int id, @RequestBody Fournisseur fournisseur) {
		Optional<Fournisseur> fournisseurData = Optional.ofNullable(fournisseurService.findOne(id));

		if (fournisseurData.isPresent()) {
			Fournisseur _fournisseur = fournisseurData.get();

			_fournisseur.setNomPrenom(fournisseur.getNomPrenom());
			_fournisseur.setAdresse(fournisseur.getAdresse());
			_fournisseur.setVille(fournisseur.getVille());
			_fournisseur.setTele(fournisseur.getTele());

			return new ResponseEntity<>(fournisseurService.save(_fournisseur), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		fournisseurService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
