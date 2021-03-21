package com.louhibi.gestiondestock.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commandes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeCommande",discriminatorType = DiscriminatorType.STRING)
public abstract class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_Commande")
	private int id;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "Date_Commande")
	private Date dateCommande;

	@Column(name = "Montant")
	private int montant;

	@Column(name = "TypeCommande",insertable= false, updatable= false)
	@Enumerated(value = EnumType.STRING)
	TypeCommande typeCommande;

	public Commande(int id, int idClient, Date dateCommande, int montant, List<LigneCommande> ligneCommandes) {
		this.id = id;
		this.dateCommande = dateCommande;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}


	public TypeCommande getTypeCommande() {
		return typeCommande;
	}

	public void setTypeCommande(TypeCommande typeCommande) {
		this.typeCommande = typeCommande;
	}


	public Commande() {
		super();
	}

}


