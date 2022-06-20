package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdticketingmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdticketingmanager.business.CDTicketingManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CDTicketingManagerRESTController {

    private final CDTicketingManagerService cdTicketingManagerService;

    public CDTicketingManagerRESTController(CDTicketingManagerService cdTicketingManagerService) {
        this.cdTicketingManagerService = cdTicketingManagerService;
    }

    @GetMapping("/createTickets/{instanceId}")
    public ResponseEntity<?> createTickets(@PathVariable String instanceId) {
        cdTicketingManagerService.createTickets(instanceId);

        return ResponseEntity.ok(instanceId);
    }

    @GetMapping("/printTickets/{instanceId}")
    public ResponseEntity<?> printTickets(@PathVariable String instanceId) {
        cdTicketingManagerService.printTickets(instanceId);

        return ResponseEntity.ok(instanceId);
    }

    @GetMapping("/prepareTicketShipping/{instanceId}")
    public ResponseEntity<?> prepareTicketShipping(@PathVariable String instanceId) {
        cdTicketingManagerService.prepareTicketShipping(instanceId);

        return ResponseEntity.ok(instanceId);
    }

    @GetMapping("/completeTicketIssue/{instanceId}")
    public ResponseEntity<?> completeTicketIssue(@PathVariable String instanceId) {
        cdTicketingManagerService.completeTicketIssue(instanceId);

        return ResponseEntity.ok(instanceId);
    }
}
