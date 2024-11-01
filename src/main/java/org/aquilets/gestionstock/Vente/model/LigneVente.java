package org.aquilets.gestionstock.Vente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquilets.gestionstock.Produit.model.Produit;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private double prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "vente_id")
    private Vente vente;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

}
