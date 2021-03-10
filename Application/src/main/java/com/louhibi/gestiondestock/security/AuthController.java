package com.louhibi.gestiondestock.security;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.louhibi.gestiondestock.entity.AppUser;
import com.louhibi.gestiondestock.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/authentification")
public class AuthController {

	private final Log logger = LogFactory.getLog(AuthController.class);
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = {"", "/"})
	public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {
		
		logger.info("Auth : Username : " + signInRequest.getUsername() + "  --------  "
				+ "Password : " + signInRequest.getPassword() + "  --------  ");
		
		final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
		
		String token = tokenUtil.generateToken(userDetails);
		JwtResponse jwtResponse = new JwtResponse(token);
		return jwtResponse;
	}
}
