package dz.elit.pay_tracker.paymentTrace.application.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreatePaymentTraceValidator.class)
public @interface ValidCreatePaymentTrace {
    String message() default "CreatePaymentActionDTO validation failed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
