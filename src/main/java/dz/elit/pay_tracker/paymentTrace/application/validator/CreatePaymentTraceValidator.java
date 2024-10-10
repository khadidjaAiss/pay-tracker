package dz.elit.pay_tracker.paymentTrace.application.validator;

import dz.elit.pay_tracker.paymentTrace.application.dto.CreatePaymentTraceDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CreatePaymentTraceValidator implements ConstraintValidator<ValidCreatePaymentTrace, CreatePaymentTraceDTO> {

    @Override
    public void initialize(ValidCreatePaymentTrace constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Validates that
     * at least one of the fields {@code numFacture}, {@code numTranche}, or {@code numMemoire} is provided in the DTO
     * or either both {@code numCheque} and {@code rip} are provided, or both are {@code null}.
     *
     * <p>If not a constraint violation is added to the context with an error message.
     *
     * @param dto     The {@link CreatePaymentTraceDTO} containing the fields to validate.
     * @param context The context in which the constraint violations are collected.
     * @return {@code true} if at least one of the required fields is provided; {@code false} otherwise.
     */
    @Override
    public boolean isValid(CreatePaymentTraceDTO dto, ConstraintValidatorContext context) {
        boolean isValid = true;
        boolean numFactureNull = dto.getNumFacture() == null;
        boolean numTrancheNull = dto.getNumTranche() == null;
        boolean numMemoireNull = dto.getNumMemoire() == null;
        boolean numChequeNull = dto.getNumCheque() == null;
        boolean ripNull = dto.getRip() == null;
        boolean codeActionNull= dto.getCodeAction()== null;

            // Check if all three fields are null
        if (numFactureNull && numTrancheNull && numMemoireNull) {
            context.buildConstraintViolationWithTemplate("At least one of numFacture, numTranche, or numMemoire must be provided")
                    .addConstraintViolation();
            isValid = false;
        }
        // Check if more than one field is not null
        if ((!numFactureNull && !numTrancheNull) || (!numFactureNull && !numMemoireNull) || (!numTrancheNull && !numMemoireNull)) {
            context.buildConstraintViolationWithTemplate("Only one of numFacture, numTranche, or numMemoire must be provided")
                    .addConstraintViolation();
            isValid = false;
        }

        // Check if both cheque number and RIP are provided
        if ((numChequeNull && ripNull)||(!numChequeNull && !ripNull) ) {
            context.buildConstraintViolationWithTemplate("Either both numCheque and rip must be provided or both must be null")
                    .addConstraintViolation();
            isValid = false;
        }
        if (codeActionNull ) {
            context.buildConstraintViolationWithTemplate("the actionCode  must be provided ")
                    .addConstraintViolation();
            isValid = false;
        }

        // Réinitialiser le contexte de violation pour éviter les doublons de message
        context.disableDefaultConstraintViolation();
        return isValid;
    }

}
