package dz.elit.pay_tracker.paymentTrace.application.dto;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import org.springframework.stereotype.Component;

@Component
public class PaymentTraceMapper {
    /**
     * Maps a {@link CreatePaymentTraceDTO} object to a {@link PaymentTrace} entity.
     *
     * @param dto The DTO object to map from.
     * @return A new {@link PaymentTrace} entity mapped from the DTO.
     */
    public PaymentTrace mapToEntity(CreatePaymentTraceDTO dto) {
        return new PaymentTrace(dto.getCodeAction(), dto.getNumFacture(), dto.getNumTranche(),
                dto.getNumMemoire(), dto.getNumCheque(), dto.getRip(), dto.getCodeClient(),
                dto.getUniteFacture(), dto.getUniteEncaissement(), dto.getTypeEnergie(),
                dto.getIsRepris(), dto.getDateOperation(), dto.getDateIntegration(), dto.getActeur(),
                false, dto.getModePaiement());
    }
    /**
     * Updates a {@link PaymentTrace} entity with data from an {@link UpdatePaymentTraceDTO} object.
     *
     * @param dto     The DTO object containing update data.
     * @param entity  The entity object to update.
     */
    public void updateEntity(UpdatePaymentTraceDTO dto, PaymentTrace entity) {
        entity.setDateLecture(dto.getDateLecture());
        entity.setSynchroniserTraiter(true);
    }

    /**
     * Maps a {@link PaymentTrace} entity to a {@link PaymentTraceDTO} object.
     *
     * @param entity The entity object to map from.
     * @return A new {@link PaymentTraceDTO} DTO mapped from the entity.
     */
    public PaymentTraceDTO mapToDto(PaymentTrace entity) {
        return new PaymentTraceDTO(entity.getId(), entity.getCodeAction(), entity.getNumFacture(), entity.getNumTranche(),
                entity.getNumMemoire(), entity.getNumCheque(), entity.getRip(), entity.getCodeClient(),
                entity.getUniteFacture(), entity.getUniteEncaissement(), entity.getTypeEnergie(),
                entity.getIsRepris(), entity.getDateSystem(), entity.getDateOperation(),
                entity.getDateEcriture(), entity.getDateLecture(), entity.getDateIntegration(),
                entity.getActeur(), entity.getSynchroniserTraiter(), entity.getModePaiement());
    }
}