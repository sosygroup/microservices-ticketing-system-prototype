package it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdcheckoutmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdcheckoutmanager.business.CDCheckoutManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CDCheckoutManagerRESTController {

    private final CDCheckoutManagerService cdCheckoutManagerService;

    public CDCheckoutManagerRESTController(CDCheckoutManagerService cdCheckoutManagerService) {
        this.cdCheckoutManagerService = cdCheckoutManagerService;
    }

    @GetMapping("/getItems/{instanceId}")
    public ResponseEntity<?> getItems(@PathVariable String instanceId) {
        String response = cdCheckoutManagerService.getItems(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/pay/{instanceId}")
    public ResponseEntity<?> pay(@PathVariable String instanceId) {
        String response = cdCheckoutManagerService.pay(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/checkoutComplete/{instanceId}")
    public ResponseEntity<?> checkoutComplete(@PathVariable String instanceId) {
        String response = cdCheckoutManagerService.checkoutComplete(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/issueTickets/{instanceId}")
    public ResponseEntity<?> issueTickets(@PathVariable String instanceId) {
        String response = cdCheckoutManagerService.issueTickets(instanceId);

        return ResponseEntity.ok(response);
    }
}
