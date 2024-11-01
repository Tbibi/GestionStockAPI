package org.aquilets.gestionstock.Achat.model;

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
public class LigneAchat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantite;
    private double prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "achat_id")
    private Achat achat;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

}
