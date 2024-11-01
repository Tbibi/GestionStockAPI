package org.aquilets.gestionstock.Produit.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquilets.gestionstock.Achat.model.LigneAchat;
import org.aquilets.gestionstock.Vente.model.LigneVente;


import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String categorie;
    private double prixUnitaire;
    private int quantiteStock;
    @OneToMany(mappedBy = "produit")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "produit")
    private List<LigneAchat> ligneAchats;

}
