package com.springboot.gestiondestock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {

	@Id
	@Column(name = "ID_Commande")
	private int id;
	
	@Column(name = "ID_Client")
	private int idClient;
	
	@Column(name = "Date_Commande")
	private String dateCommande;
	
	@Column(name = "Montant")
	private int montant;

	public Commande() {
		super();
	}

	public Commande(int idClient, String dateCommande, int montant) {
		super();
		this.idClient = idClient;
		this.dateCommande = dateCommande;
		this.montant = montant;
	}

	public Commande(int id, int idClient, String dateCommande, int montant) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.dateCommande = dateCommande;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
}
