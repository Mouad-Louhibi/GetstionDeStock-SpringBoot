package com.louhibi.gestiondestock.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_Client")
	private int id;

	@Column(name = "NomPrenom")
	private String nomPrenom;


	@Column(name = "Adresse")
	private String adresse;

	@Column(name = "Ville")
	private String ville;

	@Column(name = "Tele")
	private String tele;

	@OneToMany(mappedBy = "clientC")
	private List<CommandeClient> commandeClientList;


	public Client(String nomPrenom, String adresse, String ville, String tele) {
		this.nomPrenom = nomPrenom;
		this.adresse = adresse;
		this.ville = ville;
		this.tele = tele;
	}

	public Client() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
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
