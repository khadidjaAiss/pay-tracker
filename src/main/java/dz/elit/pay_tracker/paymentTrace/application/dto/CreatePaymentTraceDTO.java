package dz.elit.pay_tracker.paymentTrace.application.dto;

import dz.elit.pay_tracker.paymentTrace.application.validator.ValidCreatePaymentTrace;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ValidCreatePaymentTrace
public class CreatePaymentTraceDTO {

    @NotBlank
    private String codeAction;
    @NotBlank
    private String codeClient;
    @NotBlank
    private String uniteFacture;
    @NotBlank
    private String uniteEncaissement;
    @NotBlank
    private String typeEnergie;
    @NotBlank
    private String modePaiement;
    @NotBlank
    private String acteur;
    @NotNull
    private LocalDateTime dateOperation;
    @NotNull
    private LocalDateTime dateIntegration;
    private String numFacture;
    private String numTranche;
    private String numMemoire;
    private String numCheque;
    private String rip;
    private Boolean isRepris;
}
