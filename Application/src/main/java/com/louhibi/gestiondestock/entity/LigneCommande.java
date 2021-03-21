package com.louhibi.gestiondestock.entity;

import javax.persistence.*;

@Entity
@Table(name = "ligne_commande")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeCommande",discriminatorType = DiscriminatorType.STRING)
public abstract class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_Ligne_Commande")
    private int id;

    @Column(name = "Qte")
    private int quantite;

    @Column(name = "montant")
    private int montant;

    public LigneCommande(int id, Produit produit, int quantite, int montant) {
        this.id = id;
        this.quantite = quantite;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }


    public LigneCommande() {
        super();
    }

}