package com.louhibi.gestiondestock.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@Table(name = "factures")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeFacture",discriminatorType = DiscriminatorType.STRING)
public abstract class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_Facture")
	private int id;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "Date_Facture")
	private Date dateFacture;

	@Column(name = "TypeFacture",insertable= false, updatable= false)
	@Enumerated(value = EnumType.STRING)
	TypeFacture typeFacture;

	public Facture() {
		super();
	}

	public Facture(Date dateFacture) {
		super();
		this.dateFacture = dateFacture;
	}

	public Facture(int id, Date dateFacture, int montant) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCommande() {
		return dateFacture;
	}

	public void setDateCommande(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

}