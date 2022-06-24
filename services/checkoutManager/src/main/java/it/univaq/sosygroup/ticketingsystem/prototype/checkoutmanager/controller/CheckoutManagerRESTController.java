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
        String response = checkoutManagerService.processCheckout(instanceId);
        return ResponseEntity.ok(response);
    }

}
