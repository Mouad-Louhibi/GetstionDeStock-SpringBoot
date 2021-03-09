package com.louhibi.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.louhibi.gestiondestock.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer>{
	
	public AppUser save(AppUser user);
}