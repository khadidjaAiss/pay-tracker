package dz.elit.pay_tracker.paymentTrace.application;

import dz.elit.pay_tracker.paymentTrace.application.dto.CreatePaymentTraceDTO;
import dz.elit.pay_tracker.paymentTrace.application.dto.PaymentTraceDTO;
import dz.elit.pay_tracker.paymentTrace.application.dto.PaymentTraceMapper;
import dz.elit.pay_tracker.paymentTrace.application.dto.UpdatePaymentTraceDTO;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentActionAutomate;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentActionAutomateRepository;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTraceRepository;
import dz.elit.pay_tracker.paymentTrace.exception.PaymentTraceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentTraceService {
    public final PaymentTraceRepository paymentTraceRepository;
    public final PaymentActionAutomateRepository paymentActionAutomateRepository;
    public final PaymentTraceMapper paymentTraceMapper;

    @Autowired
    public PaymentTraceService(PaymentTraceRepository paymentTraceRepository, PaymentActionAutomateRepository paymentActionAutomateRepository, PaymentTraceMapper paymentTraceMapper) {
        this.paymentTraceRepository = paymentTraceRepository;
        this.paymentActionAutomateRepository = paymentActionAutomateRepository;
        this.paymentTraceMapper = paymentTraceMapper;
    }

    /**
     * Creates a new payment trace using the information provided in the specified DTO.
     *
     * @param paymentTraceDTO The DTO containing the necessary information to create the payment trace.
     * @throws PaymentTraceException If an error occurs while saving the payment trace.
     */
    @Transactional
    public void createPaymentTrace(CreatePaymentTraceDTO paymentTraceDTO) {
        try {
            verifyPaymentTrace(paymentTraceDTO);
            PaymentTrace paymentTrace = paymentTraceMapper.mapToEntity(paymentTraceDTO);
            paymentTraceRepository.save(paymentTrace);
        } catch (Exception e) {
            throw new PaymentTraceException("Failed to save payment trace", e);
        }
    }
    public void verifyPaymentTrace(CreatePaymentTraceDTO paymentTraceDTO) throws PaymentTraceException {
        Optional<PaymentActionAutomate> byCodeAction = paymentActionAutomateRepository.findByCodeAction(paymentTraceDTO.getCodeAction());
        if (byCodeAction.isEmpty()) {
            throw new PaymentTraceException("Opération Synchronisation /  Le Code Action " + paymentTraceDTO.getCodeAction() + "  est non reconnu pour la synchronisation temps réel CRMS!");
        } else {
        // Vérification si l'action précédente existe dans la table automate
        if (!paymentActionAutomateRepository.existsByAction(previousAction)) {
            throw new InvalidPaymentTraceException("Previous action '" + previousAction + "' not found in automate!");
        }

        // Si tout est valide, sauvegarder le PaymentTrace
        PaymentTrace paymentTrace = new PaymentTrace(paymentTraceDTO);
        paymentTraceRepository.save(paymentTrace);
    }
  /*  @Transactional
    public void verifyAndSavePaymentTraces(List<CreatePaymentTraceDTO> paymentTraceDTOs) throws InvalidPaymentTraceException {
        for (CreatePaymentTraceDTO paymentTraceDTO : paymentTraceDTOs) {
            verifyAndSavePaymentTrace(paymentTraceDTO);
        }
    }*/

    /**
     * Updates an existing payment trace based on the information provided in the update DTO.
     *
     * @param updatePaymentTraceDTO The DTO containing the updated information for the payment trace.
     * @throws PaymentTraceException If the payment trace with the specified ID is not found, or if an error occurs while updating the payment trace.
     */
    @Transactional
    public void updatePaymentTrace(UpdatePaymentTraceDTO updatePaymentTraceDTO) {
        try {
            PaymentTrace existingPA = paymentTraceRepository.findById(updatePaymentTraceDTO.getId())
                    .orElseThrow(() -> new PaymentTraceException("Payment trace not found with id: " + updatePaymentTraceDTO.getId()));
            paymentTraceMapper.updateEntity(updatePaymentTraceDTO, existingPA);
            paymentTraceRepository.save(existingPA);
        } catch (Exception e) {
            throw new PaymentTraceException("Failed to update payment trace", e);
        }
    }

    /**
     * Creates multiple payment traces based on the information provided in the list of DTOs.
     *
     * @param paymentTraceDTOList The list of DTOs containing the information to create the payment traces.
     * @throws PaymentTraceException If an error occurs while saving one or more payment traces.
     */
    @Transactional
    public void createPaymentTraces(List<CreatePaymentTraceDTO> paymentTraceDTOList) {
        try {
            List<PaymentTrace> entities = paymentTraceDTOList.stream()
                    .map(paymentTraceMapper::mapToEntity)
                    .toList();
            entities.forEach(paymentTraceRepository::save);
        } catch (PaymentTraceException e) {
            throw new PaymentTraceException("Failed to save one or more payment traces", e);
        }
    }

    /**
     * updates multiple payment traces based on the information provided in the list of DTOs.
     *
     * @param updatePaymentTraceDTOList The list of DTOs containing the information to update the payment traces.
     * @throws PaymentTraceException If an error occurs while saving one or more payment traces.
     */
    @Transactional
    public void updatePaymentTraces(List<UpdatePaymentTraceDTO> updatePaymentTraceDTOList) {
        try {
            updatePaymentTraceDTOList.forEach(this::updatePaymentTrace);
        } catch (PaymentTraceException e) {
            throw new PaymentTraceException("Failed to save one or more payment traces", e);
        }
    }

    /**
     * Retrieves payment traces based on the specified search criteria.
     *
     * @param numCheque  The cheque number to search for payment traces.
     * @param numFacture The invoice number to search for payment traces.
     * @param numMemoire The memory number to search for payment traces.
     * @param numTranche The tranche number to search for payment traces.
     * @param codeClient The client code to search for payment traces.
     * @return A list of PaymentTraceDTO objects that match the search criteria.
     * @throws IllegalArgumentException If none of the search criteria are provided.
     */
    public List<PaymentTraceDTO> findPaymentTracesByCriteria(String numCheque, String numFacture, String numMemoire, String numTranche , String codeClient) {
        List<PaymentTrace> list;
        if (numCheque != null) {
            list = paymentTraceRepository.findByNumCheque(numCheque);
        } else if (numFacture != null) {
            list = paymentTraceRepository.findByNumFacture(numFacture);
        } else if (numMemoire != null) {
            list = paymentTraceRepository.findByNumMemoire(numMemoire); 
        } else if (numTranche != null) {
            list = paymentTraceRepository.findByNumTranche(numTranche);
        } else if (codeClient != null) {
            list = paymentTraceRepository.findByCodeClient(codeClient);
        } else {
            throw new IllegalArgumentException("At least one search criteria must be provided.");
        }
        return list.parallelStream().map(paymentTraceMapper::mapToDto).collect(Collectors.toList());

    }

    /**
     * Retrieves payment traces based on cheque number .
     *
     * @param numCheque The cheque number to search for payment traces.
     * @return A list of PaymentTraceDTO objects that match the search criteria.
     * @throws IllegalArgumentException If none of the search criteria are provided.
     */
    public List<PaymentTraceDTO> findPaymentTracesByNumCheque(String numCheque) {
        if (numCheque == null) {
            throw new IllegalArgumentException("At least one search criteria must be provided.");
        }
        List<PaymentTrace> list = paymentTraceRepository.findByNumCheque(numCheque);
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .map(paymentTraceMapper::mapToDto)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves payment traces based on invoice number .
     *
     * @param numFacture The cheque number to search for payment traces.
     * @return A list of PaymentTraceDTO objects that match the search criteria.
     * @throws IllegalArgumentException If none of the search criteria are provided.
     */
    public List<PaymentTraceDTO> findPaymentTracesByNumFacture(String numFacture) {
        if (numFacture == null) {
            throw new IllegalArgumentException("At least one search criteria must be provided.");
        }
        List<PaymentTrace> list = paymentTraceRepository.findByNumFacture(numFacture);
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .map(paymentTraceMapper::mapToDto)
                .collect(Collectors.toList());
    } /**
     * Retrieves payment traces based on tranche number .
     *
     * @param numtranche The cheque number to search for payment traces.
     * @return A list of PaymentTraceDTO objects that match the search criteria.
     * @throws IllegalArgumentException If none of the search criteria are provided.
     */
    public List<PaymentTraceDTO> findPaymentTracesByNumTranche(String numtranche) {
        if (numtranche == null) {
            throw new IllegalArgumentException("At least one search criteria must be provided.");
        }
        List<PaymentTrace> list = paymentTraceRepository.findByNumTranche(numtranche);
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .map(paymentTraceMapper::mapToDto)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves payment traces based on memory number .
     *
     * @param numMemoire The cheque number to search for payment traces.
     * @return A list of PaymentTraceDTO objects that match the search criteria.
     * @throws IllegalArgumentException If none of the search criteria are provided.
     */
    public List<PaymentTraceDTO> findPaymentTracesByNumMemoire(String numMemoire) {
        if (numMemoire == null) {
            throw new IllegalArgumentException("At least one search criteria must be provided.");
        }
        List<PaymentTrace> list = paymentTraceRepository.findByNumMemoire(numMemoire);
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .map(paymentTraceMapper::mapToDto)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves payment traces based on client code .
     *
     * @param codeClient The cheque number to search for payment traces.
     * @return A list of PaymentTraceDTO objects that match the search criteria.
     * @throws IllegalArgumentException If none of the search criteria are provided.
     */
    public List<PaymentTraceDTO> findPaymentTracesByCodeClient(String codeClient) {
        if (codeClient == null) {
            throw new IllegalArgumentException("At least one search criteria must be provided.");
        }
        List<PaymentTrace> list = paymentTraceRepository.findByCodeClient(codeClient);
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .map(paymentTraceMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
