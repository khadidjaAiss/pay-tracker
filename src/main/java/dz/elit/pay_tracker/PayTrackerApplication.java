package dz.elit.pay_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class PayTrackerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(PayTrackerApplication.class, args);
      /*  String databaseType = ctx.getEnvironment().getProperty("database.type");
        System.err.println(databaseType);
        if ("mongodb".equalsIgnoreCase(databaseType)) {
            ctx.getEnvironment().setActiveProfiles("mongodb");
        } else if ("postgresql".equalsIgnoreCase(databaseType)) {
            ctx.getEnvironment().setActiveProfiles("postgresql");
        } else {
            System.out.println("Aucun profil actif correspondant à " + databaseType);
        }*/
        System.err.println(Arrays.stream(ctx.getEnvironment().getActiveProfiles()).toList());
    }
}
