package com.louhibi.gestiondestock.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class AppUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_Users")
	private int id;
	
	@NotNull
	@Column(name = "Email")
	private String email;
	
	@NotNull
	@Column(name = "Name")
	private String name;
	
	@NotNull
	//@JsonIgnore
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Created")
	private Date created;
	
	public AppUser() {
		
	}
	
	public AppUser(@NotNull String name, @NotNull String password) {
		this.name = name;
		this.password = password;
		this.created = new Date();
	}

	public AppUser(@NotNull String name, @NotNull String email,@NotNull String password) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.created = new Date();
	}
	
	public AppUser(@NotNull int id, @NotNull String name, @NotNull String email, @NotNull String password) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.created = new Date();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
