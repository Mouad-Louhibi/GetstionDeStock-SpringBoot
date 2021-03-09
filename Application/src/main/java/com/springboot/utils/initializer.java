package com.springboot.utils;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.security.AppUser;
import com.springboot.security.UserService;

@Component
public class initializer implements CommandLineRunner {

	private final Log logger = LogFactory.getLog(initializer.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (userService.findAll().isEmpty()) {
			logger.info("No Users accounts found. creating some users");
		
			AppUser user = new AppUser("mouad@gmail.com", "louhibi", "Mouad");
			userService.save(user);
		}
	}	
}