package com.springboot.security;

import java.util.Collections;
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

import com.springboot.utils.initializer;

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
		
		logger.info("User Loading...");
		
		User user = new User(username, username, null);
		// User user = new User("Mouad", /*passwordEncoder().encode("louhibi")*/ "louhibi", AuthorityUtils.NO_AUTHORITIES);
		// User user = new User("Mouad", /*passwordEncoder().encode("louhibi")*/ "louhibi", Collections.emptyList());
		return user;
	}

	public void save(AppUser user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		this.userRepository.save(user);
	}
	
	public List<AppUser> findAll(){
		return userRepository.findAll();
	}
}
