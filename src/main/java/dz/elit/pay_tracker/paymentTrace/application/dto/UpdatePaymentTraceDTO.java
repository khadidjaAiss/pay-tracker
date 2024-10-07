package dz.elit.pay_tracker.paymentTrace.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class UpdatePaymentTraceDTO {
    @NotNull
    private Integer id;
    @NotNull
    private LocalDateTime dateLecture;
    private Boolean synchroniserTraiter ;

}
