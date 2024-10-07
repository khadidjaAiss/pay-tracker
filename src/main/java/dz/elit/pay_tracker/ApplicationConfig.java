package dz.elit.pay_tracker;

import dz.elit.pay_tracker.paymentTrace.domain.PaymentTraceRepository;
import dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa.PaymentTraceJpaRepository;
import dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa.PaymentTraceJpaRepositoryImpl;
import dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.mongoDB.PaymentTraceMongoRepository;
import dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.mongoDB.PaymentTraceMongoRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa")
public class ApplicationConfig {
    @Bean
    @Primary
    public PaymentTraceRepository paymentTraceRepositoryJpa(PaymentTraceJpaRepository jpaRepository) {
        return new PaymentTraceJpaRepositoryImpl(jpaRepository);
    }
    @Bean
    public PaymentTraceRepository paymentTraceRepositoryMongo(PaymentTraceMongoRepository mongoRepository) {
        return new PaymentTraceMongoRepositoryImpl(mongoRepository);
    }

}

