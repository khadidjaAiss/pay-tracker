package dz.elit.pay_tracker.paymentTrace.controller;

import dz.elit.pay_tracker.paymentTrace.application.PaymentTraceService;
import dz.elit.pay_tracker.paymentTrace.application.dto.CreatePaymentTraceDTO;
import dz.elit.pay_tracker.paymentTrace.application.dto.PaymentTraceDTO;
import dz.elit.pay_tracker.paymentTrace.application.dto.UpdatePaymentTraceDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/payment-traces")
public class PaymentTraceController {
    private final PaymentTraceService paymentTraceService;

    @Autowired
    public PaymentTraceController(PaymentTraceService paymentTraceService) {
        this.paymentTraceService = paymentTraceService;
    }

    // Endpoint to create a payment Trace
    @PostMapping
    public ResponseEntity<String> create(@NotNull @Validated @RequestBody CreatePaymentTraceDTO paymentTraceDTO) {
        paymentTraceService.createPaymentTrace(paymentTraceDTO);
        return new ResponseEntity<>("Payment Trace saved successfully", HttpStatus.OK);
    }

    // Endpoint to create multiple payment Traces
    @PostMapping("/batch")
    public ResponseEntity<String> create(@NotNull @Validated  @RequestBody List<CreatePaymentTraceDTO> paymentTraceDTOs) {
        paymentTraceService.createPaymentTraces(paymentTraceDTOs);
        return new ResponseEntity<>("Payment Traces saved successfully", HttpStatus.OK);
    }

    // Endpoint to update a single Trace
    @PutMapping
    public ResponseEntity<String> update(@NotNull @Valid @RequestBody UpdatePaymentTraceDTO paymentTraceDTO) {
        paymentTraceService.updatePaymentTrace(paymentTraceDTO);
        return new ResponseEntity<>("Payment Trace updated successfully", HttpStatus.OK);

    }

    // Endpoint to update multiple payment Traces
    @PutMapping("/batch")
    public ResponseEntity<String> update(@NotNull @Valid @RequestBody List<UpdatePaymentTraceDTO> paymentTraceDTOs) {
        paymentTraceService.updatePaymentTraces(paymentTraceDTOs);
        return new ResponseEntity<>("Payment Traces updated successfully", HttpStatus.OK);
    }

    // Endpoint to retrieve payment Traces by cheque number
    @GetMapping("/by-cheque")
    public ResponseEntity<List<PaymentTraceDTO>> findByCheque(@NotNull @RequestParam String chequeNumber) {
        List<PaymentTraceDTO> paymentTraceDTOS = paymentTraceService.findPaymentTracesByNumCheque(chequeNumber);
        return new ResponseEntity<>(paymentTraceDTOS, HttpStatus.OK);
    }

    // Endpoint to retrieve payment Traces by invoice number
    @GetMapping("/by-invoice")
    public ResponseEntity<List<PaymentTraceDTO>> findByInvoice(@NotNull @RequestParam String invoiceNumber) {
        List<PaymentTraceDTO> paymentTraceDTOS = paymentTraceService.findPaymentTracesByNumFacture(invoiceNumber);
        return new ResponseEntity<>(paymentTraceDTOS, HttpStatus.OK);
    }

    // Endpoint to retrieve payment Traces by memory number
    @GetMapping("/by-memory")
    public ResponseEntity<List<PaymentTraceDTO>> findByMemory(@NotNull @RequestParam String memoryNumber) {
        List<PaymentTraceDTO> paymentTraceDTOS = paymentTraceService.findPaymentTracesByNumMemoire(memoryNumber);
        return new ResponseEntity<>(paymentTraceDTOS, HttpStatus.OK);
    }
    // Endpoint to retrieve payment Traces by tranche number
    @GetMapping("/by-tranche")
    public ResponseEntity<List<PaymentTraceDTO>> findByTranche(@NotNull @RequestParam String trancheNumber) {
        List<PaymentTraceDTO> paymentTraceDTOS = paymentTraceService.findPaymentTracesByNumTranche(trancheNumber);
        return new ResponseEntity<>(paymentTraceDTOS, HttpStatus.OK);
    }

    // Endpoint to retrieve payment Traces by client code
    @GetMapping("/by-client-code")
    public ResponseEntity<List<PaymentTraceDTO>> findByClientCode(@NotNull @RequestParam String clientCode) {
        List<PaymentTraceDTO> paymentTraceDTOS = paymentTraceService.findPaymentTracesByCodeClient(clientCode);
        return new ResponseEntity<>(paymentTraceDTOS, HttpStatus.OK);
    }

    // Endpoint to search payment Traces by multiple criteria
    @GetMapping("/search")
    public ResponseEntity<List<PaymentTraceDTO>> search(
            @RequestParam(required = false) String chequeNumber,
            @RequestParam(required = false) String invoiceNumber,
            @RequestParam(required = false) String memoryNumber,
            @RequestParam(required = false) String trancheNumber,
            @RequestParam(required = false) String clientCode) {
        List<PaymentTraceDTO> products = paymentTraceService.findPaymentTracesByCriteria(chequeNumber, invoiceNumber, memoryNumber, trancheNumber, clientCode);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
