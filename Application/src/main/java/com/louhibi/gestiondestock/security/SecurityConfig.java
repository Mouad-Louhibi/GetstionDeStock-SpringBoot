package com.louhibi.gestiondestock.security;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final Log logger = LogFactory.getLog(SecurityConfig.class);
	
	private final String[] PUBLIC_ENDPOINTS = {
			"/api/v1/**"
	};
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	public AuthFilter authFilter(){
		return new AuthFilter();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		logger.info("Mouad Louhibi : Http Configuration...");
		
		http
		 .cors().and().csrf().disable()
		 .sessionManagement()
		 	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 	.and()
		 .authorizeRequests()
		 	.antMatchers(PUBLIC_ENDPOINTS).permitAll()
		 	.anyRequest().authenticated()
		 	.and()
		 	.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}