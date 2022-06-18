package it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdticketing.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdticketing.business.CDTicketingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CDTicketingRESTController {

    private final CDTicketingService cdTicketingService;

    public CDTicketingRESTController(CDTicketingService cdTicketingService) {
        this.cdTicketingService = cdTicketingService;
    }

    @GetMapping("/createTickets/{instanceId}")
    public ResponseEntity<?> createTickets(@PathVariable String instanceId) {
        cdTicketingService.createTickets(instanceId);

        return ResponseEntity.ok(instanceId);
    }

    @GetMapping("/printTickets/{instanceId}")
    public ResponseEntity<?> printTickets(@PathVariable String instanceId) {
        cdTicketingService.printTickets(instanceId);

        return ResponseEntity.ok(instanceId);
    }

    @GetMapping("/prepareTicketShipping/{instanceId}")
    public ResponseEntity<?> prepareTicketShipping(@PathVariable String instanceId) {
        cdTicketingService.prepareTicketShipping(instanceId);

        return ResponseEntity.ok(instanceId);
    }

    @GetMapping("/completeTicketIssue/{instanceId}")
    public ResponseEntity<?> completeTicketIssue(@PathVariable String instanceId) {
        cdTicketingService.completeTicketIssue(instanceId);

        return ResponseEntity.ok(instanceId);
    }
}
