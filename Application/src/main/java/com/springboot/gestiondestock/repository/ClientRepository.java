package com.springboot.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.gestiondestock.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
