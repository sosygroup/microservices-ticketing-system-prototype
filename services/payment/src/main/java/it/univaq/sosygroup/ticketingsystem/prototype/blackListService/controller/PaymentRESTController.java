package it.univaq.sosygroup.ticketingsystem.prototype.blackListService.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.blackListService.business.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentRESTController {

    private final PaymentService paymentService;

    public PaymentRESTController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/pay/{instanceId}")
    public ResponseEntity<String> pay(@PathVariable String instanceId) {
        String response = "Payment instance: " + instanceId + " - Operation: Pay" ;
        paymentService.pay(instanceId);
        return ResponseEntity.ok(response);
    }

}
