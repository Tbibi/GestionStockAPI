package org.aquilets.gestionstock.Produit.services;

import org.aquilets.gestionstock.Produit.model.Produit;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProduitService {
    ResponseEntity<List<Produit>> getAllProduits();
    ResponseEntity<Produit> getProduitById(Long id);
    ResponseEntity<Produit> addProduit(Produit produit);
    ResponseEntity<Produit> updateProduit(Long id, Produit produitDetails);
    ResponseEntity<Void> deleteProduit(Long id);
}
