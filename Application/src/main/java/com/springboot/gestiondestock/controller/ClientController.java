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

import com.springboot.gestiondestock.entity.Client;
import com.springboot.gestiondestock.service.ClientService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Client>> getAllClients(){
		List<Client> result = clientService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable int id) {
		Client result = clientService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<Client> createNewClient(/*@Valid*/@RequestBody Client client) {
		Client result = clientService.save(client);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

