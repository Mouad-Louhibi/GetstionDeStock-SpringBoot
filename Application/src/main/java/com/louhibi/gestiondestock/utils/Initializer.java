package com.louhibi.gestiondestock.utils;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.louhibi.gestiondestock.entity.AppUser;
import com.louhibi.gestiondestock.service.UserService;

@Component
public class Initializer implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(Initializer.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (userService.findAll() == null) {
			logger.info("Mouad Louhibi : No Users accounts found. creating some users");
		
			AppUser user = new AppUser("root@gmail.com", "root", "root");
			userService.saveUser(user);
		}
	}	
}