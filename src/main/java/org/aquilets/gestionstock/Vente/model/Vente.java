package org.aquilets.gestionstock.Vente.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquilets.gestionstock.Paiement.model.Paiement;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateVente;
    private double montantTotal;

//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "vente")
    private List<Paiement> paiements;

}
