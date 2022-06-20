package it.univaq.sosygroup.ticketingsystem.prototype.checkoutmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.checkoutmanager.business.CheckoutManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutManagerRESTController {

    private final CheckoutManagerService checkoutManagerService;

    public CheckoutManagerRESTController(CheckoutManagerService checkoutManagerService) {
        this.checkoutManagerService = checkoutManagerService;
    }

    @GetMapping("/processCheckout/{instanceId}")
    public ResponseEntity<String> processCheckout(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Checkout Manager - Operation: Process Checkout", instanceId);
        checkoutManagerService.issueTickets(instanceId);
        return ResponseEntity.ok(response);
    }

}
