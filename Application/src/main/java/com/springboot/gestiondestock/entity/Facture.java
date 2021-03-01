package com.springboot.gestiondestock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {

	@Id
	@Column(name = "ID_Facture")
	private int id;
	
	@Column(name = "ID_Client")
	private int idClient;
	
	@Column(name = "Date_Facture")
	private String dateFacture;
	
	@Column(name = "Montant")
	private int montant;

	public Facture() {
		super();
	}

	public Facture(int idClient, String dateFacture, int montant) {
		super();
		this.idClient = idClient;
		this.dateFacture = dateFacture;
		this.montant = montant;
	}

	public Facture(int id, int idClient, String dateFacture, int montant) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.dateFacture = dateFacture;
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
		return dateFacture;
	}

	public void setDateCommande(String dateFacture) {
		this.dateFacture = dateFacture;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
}