package dz.elit.pay_tracker.paymentTrace.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
public class PaymentTraceDTO {

    private final Integer id;
    private final String codeAction;
    private final String numFacture;
    private final String numTranche;
    private final String numMemoire;
    private final String numCheque;
    private final String rip;
    private final String codeClient;
    private final String uniteFacture;
    private final String uniteEncaissement;
    private final String typeEnergie;
    private final Boolean isRepris;
    private final LocalDateTime dateSystem;
    private final LocalDateTime dateOperation;
    private final LocalDateTime dateEcriture;
    private final LocalDateTime dateLecture;
    private final LocalDateTime dateIntegration;
    private final String acteur;
    private final Boolean synchroniserTraiter ;
    private final String modePaiement;
}
