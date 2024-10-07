package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.mongoDB;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("paymentTraceMongoRepository")
public interface PaymentTraceMongoRepository extends MongoRepository<PaymentTrace, Integer> {

    List<PaymentTrace> findByNumFacture(String numFacture);

    List<PaymentTrace> findByNumMemoire(String numMemoire);

    List<PaymentTrace> findByNumTranche(String numTranche);


    List<PaymentTrace> findByNumCheque(String numCheque);

    List<PaymentTrace> findByCodeClient(String codeClient);
}
