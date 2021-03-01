package com.springboot.gestiondestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.gestiondestock.entity.Client;
import com.springboot.gestiondestock.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client findOne(int id) {
		return clientRepository.findById(id).get();
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(int id) {
		clientRepository.deleteById(id);
	}
}
