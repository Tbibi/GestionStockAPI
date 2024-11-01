package org.aquilets.gestionstock.Produit.repository;

import org.aquilets.gestionstock.Produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Object> findByNom(String nom);
}
