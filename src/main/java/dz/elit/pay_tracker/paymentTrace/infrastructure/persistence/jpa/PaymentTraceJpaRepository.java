package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("paymentTraceJpaRepository")
public interface PaymentTraceJpaRepository extends CrudRepository<PaymentTrace, Integer> {

    List<PaymentTrace> findByNumFacture(String numFacture);

    List<PaymentTrace> findByNumMemoire(String numMemoire);

    List<PaymentTrace> findByNumTranche(String numTranche);

    List<PaymentTrace> findByNumCheque(String numCheque);

    List<PaymentTrace> findByCodeClient(String codeClient);
}
