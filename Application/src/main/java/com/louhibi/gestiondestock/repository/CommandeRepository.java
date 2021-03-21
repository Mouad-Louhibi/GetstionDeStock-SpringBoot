package com.louhibi.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louhibi.gestiondestock.entity.Commande;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
