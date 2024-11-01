package org.aquilets.gestionstock.Produit.repository;

import org.aquilets.gestionstock.Produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
