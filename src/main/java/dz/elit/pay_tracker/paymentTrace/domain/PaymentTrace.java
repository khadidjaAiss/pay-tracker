package dz.elit.pay_tracker.paymentTrace.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name = "commun_paiement" , schema = "sch_commun")
public class PaymentTrace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code_action", nullable = false)
    private String codeAction;
    @Column(name = "num_facture")
    private String numFacture;
    @Column(name = "num_tranche")
    private String numTranche;
    @Column(name = "num_memoire")
    private String numMemoire;
    @Column(name = "num_cheque")
    private String numCheque;
    @Column(name = "rip")
    private String rip;
    @Column(name = "code_client", nullable = false)
    private String codeClient;
    @Column(name = "unite_facture", nullable = false)
    private String uniteFacture;
    @Column(name = "unite_encaissement", nullable = false)
    private String uniteEncaissement;
    @Column(name = "type_energie")
    private String typeEnergie;
    @Column(name = "is_repris")
    private Boolean isRepris;
    @Column(name = "acteur")
    private String acteur;
    @Column(name = "synchroniser_traiter")
    private Boolean synchroniserTraiter = false;
    @Column(name = "mode_paiement")
    private String modePaiement;
    @Column(name = "date_operation", nullable = false)
    private LocalDateTime dateOperation;
    @Column(name = "date_integration")
    private LocalDateTime dateIntegration;
    @Column(name = "date_ecriture")
    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    private LocalDateTime dateEcriture;
    @Column(name = "date_system")
    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    private LocalDateTime dateSystem;
    @Column(name = "date_lecture")
    private LocalDateTime dateLecture;

    public PaymentTrace(String codeAction, String numFacture, String numTranche, String numMemoire, String numCheque, String rip, String codeClient, String uniteFacture, String uniteEncaissement, String typeEnergie, Boolean isRepris, LocalDateTime dateOperation, LocalDateTime dateIntegration, String acteur, Boolean synchroniserTraiter, String modePaiement) {
        this.codeAction = codeAction;
        this.numFacture = numFacture;
        this.numTranche = numTranche;
        this.numMemoire = numMemoire;
        this.numCheque = numCheque;
        this.rip = rip;
        this.codeClient = codeClient;
        this.uniteFacture = uniteFacture;
        this.uniteEncaissement = uniteEncaissement;
        this.typeEnergie = typeEnergie;
        this.isRepris = isRepris;
        this.dateOperation = dateOperation;
        this.dateIntegration = dateIntegration;
        this.acteur = acteur;
        this.synchroniserTraiter = synchroniserTraiter;
        this.modePaiement = modePaiement;
    }
}
