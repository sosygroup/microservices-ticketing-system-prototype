package it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdticketingmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdticketingmanager.business.CDTicketingManagerService;
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
        String response = cdTicketingManagerService.createTickets(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/printTickets/{instanceId}")
    public ResponseEntity<?> printTickets(@PathVariable String instanceId) {
        String response = cdTicketingManagerService.printTickets(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/prepareTicketShipping/{instanceId}")
    public ResponseEntity<?> prepareTicketShipping(@PathVariable String instanceId) {
        String response = cdTicketingManagerService.prepareTicketShipping(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketIssueCompleted/{instanceId}")
    public ResponseEntity<?> ticketIssueCompleted(@PathVariable String instanceId) {
        String response = cdTicketingManagerService.ticketIssueCompleted(instanceId);

        return ResponseEntity.ok(response);
    }
}
