package com.louhibi.gestiondestock.service;

//import java.util.Collections;
import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.AppUser;
import com.louhibi.gestiondestock.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final Log logger = LogFactory.getLog(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		logger.info("Mouad Louhibi : User Loading...");
		
		User user4 = new User("Leo", passwordEncoder().encode("Messi"), AuthorityUtils.NO_AUTHORITIES);
		//User user2 = new User("Mouad", passwordEncoder().encode("louhibi"), AuthorityUtils.NO_AUTHORITIES);
		//User user3 = new User("root", passwordEncoder().encode("root"), Collections.emptyList());
		return user4;
	}
	
	public List<AppUser> findAll(){
		return userRepository.findAll();
	}
	
	public AppUser findOne(int id) {
		return userRepository.findById(id).get();
	}
	
	public AppUser save(AppUser user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public void delete(int id) {
		userRepository.deleteById(id);
	}
}