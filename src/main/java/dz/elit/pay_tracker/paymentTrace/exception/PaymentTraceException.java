package dz.elit.pay_tracker.paymentTrace.exception;

public class PaymentTraceException extends RuntimeException {
    public PaymentTraceException(String message) {
        super(message);
    }

    public PaymentTraceException(String message, Throwable cause) {
        super(message, cause);
    }

}
