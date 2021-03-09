package com.louhibi.gestiondestock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@Column(name = "ID_Produit")
	private int id;
	
	@Column(name = "Libelle")
	private String libelle;
	
	@Column(name = "Genre")
	private String genre;
	
	@Column(name = "Prix")
	private int prix;
	
	@Column(name = "Cout")
	private int cout;
	
	@Column(name = "ID_Categorie")
	private int idCategorie;
	
	public Produit() {
		super();
	}

	public Produit(String libelle, String genre, int prix, int cout, int idCategorie) {
		super();
		this.libelle = libelle;
		this.genre = genre;
		this.prix = prix;
		this.cout = cout;
		this.idCategorie = idCategorie;
	}
	
	public Produit(int id, String libelle, String genre, int prix, int cout, int idCategorie) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.genre = genre;
		this.prix = prix;
		this.cout = cout;
		this.idCategorie = idCategorie;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getCout() {
		return cout;
	}
	
	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
}
