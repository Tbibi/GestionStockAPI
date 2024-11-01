package org.aquilets.gestionstock.Produit.services;

import org.aquilets.gestionstock.Produit.model.Produit;
import org.aquilets.gestionstock.Produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitRepository.findAll();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Produit> getProduitById(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit not found with id " + id));
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }
    @Override
    public Produit getProduitByNom(String nom) {
        return (Produit) produitRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Produit not found with name " + nom));
    }

    @Override
    public ResponseEntity<Produit> addProduit(Produit produit) {
        Produit savedProduit = produitRepository.save(produit);
        return new ResponseEntity<>(savedProduit, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Produit> updateProduit(Long id, Produit produitDetails) {
        return produitRepository.findById(id).map(produit -> {
            produit.setNom(produitDetails.getNom());
            produit.setCategorie(produitDetails.getCategorie());
            produit.setPrixUnitaire(produitDetails.getPrixUnitaire());
            produit.setQuantiteStock(produitDetails.getQuantiteStock());
            Produit updatedProduit = produitRepository.save(produit);
            return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
        }).orElseThrow(() -> new RuntimeException("Produit not found with id " + id));
    }

    @Override
    public ResponseEntity<Void> deleteProduit(Long id) {
        produitRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
