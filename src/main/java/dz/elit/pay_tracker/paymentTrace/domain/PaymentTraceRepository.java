package dz.elit.pay_tracker.paymentTrace.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface PaymentTraceRepository {
    /**
     * create a PaymentTrace .
     *
     * @param paymentTrace to create.
     * @return the created  PaymentTrace.
     */
    PaymentTrace save(PaymentTrace paymentTrace);

    /**
     * Retrieves an optional PaymentTrace by its id.
     *
     * @param id The id of the PaymentTrace to retrieve.
     * @return An optional containing the PaymentTrace, or empty if none found.
     */
    Optional<PaymentTrace> findById(Integer id);

    /**
     * Retrieves all PaymentTraces associated with a specific invoice number.
     *
     * @param numFacture The invoice number to search for.
     * @return A list of PaymentTraces associated with the given invoice number.
     */
    List<PaymentTrace> findByNumFacture(String numFacture);

    /**
     * Retrieves all PaymentTraces associated with a specific memory number.
     *
     * @param numMemoire The memory number to search for.
     * @return A list of PaymentTraces associated with the given memory number.
     */
    List<PaymentTrace> findByNumMemoire(String numMemoire);
    /**
     * Retrieves all PaymentTraces associated with a specific tranche number.
     *
     * @param numTranche The tranche number to search for.
     * @return A list of PaymentTraces associated with the given tranche number.
     */
    List<PaymentTrace> findByNumTranche(String numTranche);

    /**
     * Retrieves all PaymentTraces associated with a specific cheque number.
     *
     * @param numCheque The cheque number to search for.
     * @return A list of PaymentTraces associated with the given cheque number.
     */
    List<PaymentTrace> findByNumCheque(String numCheque);

    /**
     * Retrieves all PaymentTraces associated with a specific client code.
     *
     * @param codeClient The client code to search for.
     * @return A list of PaymentTraces associated with the given client code.
     */
    List<PaymentTrace> findByCodeClient(String codeClient);
}
