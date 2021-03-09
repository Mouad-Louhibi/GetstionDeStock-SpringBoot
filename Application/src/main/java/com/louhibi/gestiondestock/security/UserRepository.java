package com.louhibi.gestiondestock.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer>{

	public AppUser save(AppUser user);

}
