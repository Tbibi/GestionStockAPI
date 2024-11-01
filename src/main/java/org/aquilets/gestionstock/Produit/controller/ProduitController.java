package org.aquilets.gestionstock.Produit.controller;



import org.aquilets.gestionstock.Produit.model.Produit;
import org.aquilets.gestionstock.Produit.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = (List<Produit>) produitService.getAllProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduitById(id).getBody();
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }
    @GetMapping("/name/{nom}")
    public ResponseEntity<Produit> getProduitByName(@PathVariable String nom) {
        Produit produit = produitService.getProduitByNom(nom);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
        Produit createdProduit = produitService.addProduit(produit).getBody();
        return new ResponseEntity<>(createdProduit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        Produit updatedProduit = produitService.updateProduit(id, produitDetails).getBody();
        return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
