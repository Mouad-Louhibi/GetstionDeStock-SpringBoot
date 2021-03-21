package com.louhibi.gestiondestock.entity;

import javax.persistence.*;
import java.util.List;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;


@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Produit")
    private int id;

    @Column(name = "Libelle")
    private String libelle;

    @Column(name = "Reference")
    private String reference;

    @Column(name = "Genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "Prix")
    private int prix;

    @Column(name = "Cout")
    private int cout;

    @Column(name = "QteDispo")
    private int qteDispo;

    @Column(name = "QteStock")
    private int qteStock;

    @Column(name = "TypeProduit")
    @Enumerated(value = EnumType.STRING)
    TypeProduit typeProduit;

    @OneToMany(mappedBy = "produitLigneCommande")
    List<LigneCommandeClient> produitLigneCommande;


    public Produit() {
        super();
    }

    public Produit(String libelle, Genre genre, int prix, int cout, int qteStock, int qteDispo,TypeProduit typeProduit) {
        super();
        this.libelle = libelle;
        this.genre = genre;
        this.prix = prix;
        this.cout = cout;
        this.qteDispo = qteDispo;
        this.qteStock = qteStock;
        this.typeProduit = typeProduit;
    }

    public Produit(int id, String libelle, Genre genre, int prix, int cout,TypeProduit typeProduit) {
        super();
        this.id = id;
        this.libelle = libelle;
        this.genre = genre;
        this.prix = prix;
        this.cout = cout;
        this.typeProduit = typeProduit;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
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

    public int getQteDispo() {
        return qteDispo;
    }

    public void setQteDispo(int qteDispo) {
        this.qteDispo = qteDispo;
    }

    public TypeProduit getTypeProduit() { return typeProduit; }

    public void setTypeProduit(TypeProduit typeProduit) { this.typeProduit = typeProduit; }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }
}
