package com.louhibi.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louhibi.gestiondestock.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
