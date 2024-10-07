package dz.elit.pay_tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.jpa")
@EnableMongoRepositories(basePackages = "dz.elit.pay_tracker.paymentTrace.infrastructure.persistence.mongoDB")
public class RepositoryConfig {
//    @Value("${database.type}")
//    private String databaseType;
//    // Define your JPA repository
//   /* @Bean (name = "repo")
//    @Primary
//    @ConditionalOnProperty(name = "database.type", havingValue = "postgres")
//    public PaymentTraceJpaRepository jpaRepository() {
//        return null; // Spring Data will provide the implementation
//    }
//
//    // Define your MongoDB repository
//    @Bean(name = "repo")
//    @ConditionalOnProperty(name = "database.type", havingValue = "mongodb")
//    public PaymentTraceMongoDBRepository mongoDBRepository() {
//        return null; // Spring Data will provide the implementation
//    }*/

}

