package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.mongoDB;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PaymentTraceMongoRepositoryImpl")
public class PaymentTraceMongoRepositoryImpl implements PaymentTraceRepository {
    public final PaymentTraceMongoRepository mongoRepository;

    @Autowired
    public PaymentTraceMongoRepositoryImpl(PaymentTraceMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public PaymentTrace save(PaymentTrace paymentTrace) {
        return mongoRepository.save(paymentTrace);
    }

    @Override
    public List<PaymentTrace> saveAll(List<PaymentTrace> paymentTraces) {
        return mongoRepository.saveAll(paymentTraces);
    }

    @Override
    public PaymentTrace update(PaymentTrace paymentTrace) {
        return mongoRepository.save(paymentTrace);
    }

    @Override
    public Optional<PaymentTrace> findById(Integer id) {
        return mongoRepository.findById(id);
    }

    @Override
    public List<PaymentTrace> findByNumFacture(String numFacture) {
        return mongoRepository.findByNumFacture(numFacture);
    }

    @Override
    public List<PaymentTrace> findByNumMemoire(String numMemoire) {
        return mongoRepository.findByNumMemoire(numMemoire);
    }

    @Override
    public List<PaymentTrace> findByNumTranche(String numTranche) {
        return mongoRepository.findByNumTranche(numTranche);
    }

    @Override
    public List<PaymentTrace> findByNumCheque(String numCheque) {
        return mongoRepository.findByNumCheque(numCheque);
    }

    @Override
    public List<PaymentTrace> findByCodeClient(String codeClient) {
        return mongoRepository.findByCodeClient(codeClient);
    }
}
