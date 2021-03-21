package com.louhibi.gestiondestock.entity;

import javax.persistence.*;

@Entity
@Table(name = "ligne_facture")
public class LigneFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LFacture")
	private int id;
	
	@Column(name = "ID_Facture")
	private int idFacture;
	
	@Column(name = "Montant")
	private int montant;

	public LigneFacture() {
		super();
	}

	public LigneFacture(int idFacture, int montant) {
		super();
		this.idFacture = idFacture;
		this.montant = montant;
	}

	public LigneFacture(int id, int idFacture, int montant) {
		super();
		this.id = id;
		this.idFacture = idFacture;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
}
