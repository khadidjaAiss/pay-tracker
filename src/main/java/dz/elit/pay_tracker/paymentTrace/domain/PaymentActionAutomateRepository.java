package dz.elit.pay_tracker.paymentTrace.domain;

import java.util.List;
import java.util.Optional;

public interface PaymentActionAutomateRepository {

    /**
     * Retrieves all PaymentActionAutomate associated with a specific action code.
     *
     * @param codeAction The action code to search for.
     * @return A list of PaymentActionAutomates associated with the given action code.
     */
    Optional<PaymentActionAutomate> findByCodeAction(String codeAction);


}
