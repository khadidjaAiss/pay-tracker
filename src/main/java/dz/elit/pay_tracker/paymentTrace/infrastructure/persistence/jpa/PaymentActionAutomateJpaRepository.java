package dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentActionAutomate;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentActionAutomateRepository;
import dz.elit.pay_tracker.paymentTrace.domain.PaymentTrace;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//@Primary
@Profile("postgresql")
public interface PaymentActionAutomateJpaRepository extends PaymentActionAutomateRepository, CrudRepository<PaymentTrace, Integer> {
    @Override
    Optional<PaymentActionAutomate> findByCodeAction(String codeAction);
}
