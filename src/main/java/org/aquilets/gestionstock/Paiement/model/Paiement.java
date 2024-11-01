package org.aquilets.gestionstock.Paiement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aquilets.gestionstock.Achat.model.Achat;
import org.aquilets.gestionstock.Vente.model.Vente;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datePaiement;
    private double montant;
    private String typePaiement;

    @ManyToOne
    @JoinColumn(name = "vente_id", nullable = true)
    private Vente vente;

    @ManyToOne
    @JoinColumn(name = "achat_id", nullable = true)
    private Achat achat;

}
