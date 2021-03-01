package com.springboot.gestiondestock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_commande")
public class LigneCommande {

	@Id
	@Column(name = "ID_LCommande")
	private int id;
	
	@Column(name = "ID_Commande")
	private int idCommande;
	
	@Column(name = "ID_Produit")
	private int idProduit;
	
	@Column(name = "Qte")
	private int quantite;

	public LigneCommande() {
		super();
	}

	public LigneCommande(int idCommande, int idProduit, int quantite) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.quantite = quantite;
	}

	public LigneCommande(int id, int idCommande, int idProduit, int quantite) {
		super();
		this.id = id;
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.quantite = quantite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
