package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTraceRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//@Primary
@Profile("postgresql")
public interface PaymentTraceJpaRepository extends PaymentTraceRepository,CrudRepository<PaymentTrace, Integer> {

    List<PaymentTrace> findByNumFacture(String numFacture);

    List<PaymentTrace> findByNumMemoire(String numMemoire);

    List<PaymentTrace> findByNumTranche(String numTranche);

    List<PaymentTrace> findByNumCheque(String numCheque);

    List<PaymentTrace> findByCodeClient(String codeClient);
}
