package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.mongoDB;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTraceRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
@Profile("mongodb")
public interface PaymentTraceMongoDBRepository extends PaymentTraceRepository,MongoRepository<PaymentTrace, Integer> {

    List<PaymentTrace> findByNumFacture(String numFacture);

    List<PaymentTrace> findByNumMemoire(String numMemoire);

    List<PaymentTrace> findByNumTranche(String numTranche);

    List<PaymentTrace> findByNumCheque(String numCheque);

    List<PaymentTrace> findByCodeClient(String codeClient);
}
