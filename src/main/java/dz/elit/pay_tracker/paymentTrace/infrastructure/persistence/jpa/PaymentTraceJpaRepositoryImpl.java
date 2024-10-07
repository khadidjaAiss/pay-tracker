package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PaymentTraceJpaRepositoryImpl")
public class PaymentTraceJpaRepositoryImpl implements PaymentTraceRepository {
    public final PaymentTraceJpaRepository jpaRepository;

    @Autowired
    public PaymentTraceJpaRepositoryImpl(PaymentTraceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PaymentTrace save(PaymentTrace paymentTrace) {
        return jpaRepository.save(paymentTrace);
    }

    @Override
    public List<PaymentTrace> saveAll(List<PaymentTrace> paymentTraces) {
        return (List<PaymentTrace>) jpaRepository.saveAll(paymentTraces);
    }

    @Override
    public PaymentTrace update(PaymentTrace paymentTrace) {
        return jpaRepository.save(paymentTrace);
    }

    @Override
    public Optional<PaymentTrace> findById(Integer id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<PaymentTrace> findByNumFacture(String numFacture) {
        return jpaRepository.findByNumFacture(numFacture);
    }

    @Override
    public List<PaymentTrace> findByNumMemoire(String numMemoire) {
        return jpaRepository.findByNumMemoire(numMemoire);
    }

    @Override
    public List<PaymentTrace> findByNumTranche(String numTranche) {
        return jpaRepository.findByNumTranche(numTranche);
    }

    @Override
    public List<PaymentTrace> findByNumCheque(String numCheque) {
        return jpaRepository.findByNumCheque(numCheque);
    }

    @Override
    public List<PaymentTrace> findByCodeClient(String codeClient) {
        return jpaRepository.findByCodeClient(codeClient);
    }
}
