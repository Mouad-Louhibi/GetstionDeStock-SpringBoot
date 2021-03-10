package com.louhibi.gestiondestock.controller;

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

import com.louhibi.gestiondestock.entity.AppUser;
import com.louhibi.gestiondestock.service.UserService;

@Controller
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<AppUser>> getAllUsers(){
		List<AppUser> result = userService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AppUser> getUserById(@PathVariable int id) {
		AppUser result = userService.findOne(id);
		 return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<AppUser> createNewUser(/*@Valid*/@RequestBody AppUser user) {
		// AppUser newUser = new AppUser(user.getName(), user.getEmail(), user.getPassword());
		AppUser result = userService.saveUser(user);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id){
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
