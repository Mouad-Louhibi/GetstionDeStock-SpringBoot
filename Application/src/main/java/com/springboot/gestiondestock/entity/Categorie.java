package com.springboot.gestiondestock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@Column(name = "ID_Categorie")
	private int id;
	
	@Column(name = "Description_Categorie")
	private String description;

	public Categorie() {
		super();
	}

	public Categorie(String description) {
		super();
		this.description = description;
	}

	public Categorie(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
