package com.louhibi.gestiondestock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {

	@Id
	@Column(name = "ID_Fournisseur")
	private int id;
	
	@Column(name = "CIN")
	private String cin; 
	
	@Column(name = "Nom")
	private String nom;
	
	@Column(name = "Prenom")
	private String prenom;
	
	@Column(name = "Adresse")
	private String adresse;
	
	@Column(name = "Ville")
	private String ville;
	
	@Column(name = "Tele")
	private String tele;

	public Fournisseur() {
		super();
	}

	public Fournisseur(String cin, String nom, String prenom, String adresse, String ville, String tele) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.tele = tele;
	}

	public Fournisseur(int id, String cin, String nom, String prenom, String adresse, String ville, String tele) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.tele = tele;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
}
