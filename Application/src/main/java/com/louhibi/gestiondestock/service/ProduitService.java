package com.louhibi.gestiondestock.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louhibi.gestiondestock.entity.Produit;
import com.louhibi.gestiondestock.repository.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	public List<Produit> findAll(){
		return produitRepository.findAll();
	}
	
	public Produit findOne(int id) {
		return produitRepository.findById(id).get();
	}
	
	public Produit save(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public void delete(int id) {
		produitRepository.deleteById(id);
	}
	
	/*
    public List<Produit> getProduitsSortedByName() {
        List<Produit> produits = new ArrayList<>(produitRepository.findAll());
        List<Produit> sortedproduits = new ArrayList<>();
        while(produits.size()!=0)
        {
            int posMin=0;
            for (int i=1;i<produits.size();i++)
            {
                if(produits.get(posMin).getName().
                        compareTo(produits.get(i).getName())>0)
                    posMin=i;
            }
            Produit tmp=produits.get(posMin);
            sortedUsers.add(tmp);
            
            produits.remove(tmp);
            
            
        }
        // return sortedUsers;
        
        return produits;
    }
    */
}
