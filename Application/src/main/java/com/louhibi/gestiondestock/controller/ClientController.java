package com.louhibi.gestiondestock.controller;

import java.util.List;
import java.util.Optional;

import com.louhibi.gestiondestock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.louhibi.gestiondestock.entity.Client;
import com.louhibi.gestiondestock.service.ClientService;

@Controller
@RestController
@CrossOrigin
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

	@PutMapping (value = {"", "/{id}"})
	public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
		Optional<Client> clientData = Optional.ofNullable(clientService.findOne(id));

		if (clientData.isPresent()) {
			Client _client = clientData.get();

			_client.setNomPrenom(client.getNomPrenom());
			_client.setAdresse(client.getAdresse());
			_client.setVille(client.getVille());
			_client.setTele(client.getTele());

			return new ResponseEntity<>(clientService.save(_client), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

