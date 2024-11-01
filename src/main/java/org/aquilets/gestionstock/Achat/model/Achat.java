package org.aquilets.gestionstock.Achat.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquilets.gestionstock.Fourniseur.model.Fournisseur;
import org.aquilets.gestionstock.Paiement.model.Paiement;


import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Achat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateAchat;
    private double montantTotal;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "achat")
    private List<LigneAchat> ligneAchats;

    @OneToMany(mappedBy = "achat")
    private List<Paiement> paiements;

}
