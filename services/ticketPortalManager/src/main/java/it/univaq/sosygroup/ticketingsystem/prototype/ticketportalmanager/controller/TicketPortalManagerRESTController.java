package it.univaq.sosygroup.ticketingsystem.prototype.ticketportalmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.ticketportalmanager.business.TicketPortalManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketPortalManagerRESTController {

    private final TicketPortalManagerService ticketPortalManagerService;

    public TicketPortalManagerRESTController(TicketPortalManagerService ticketPortalManagerService) {
        this.ticketPortalManagerService = ticketPortalManagerService;
    }

    @GetMapping("/selectTickets/{instanceId}")
    public ResponseEntity<String> selectTickets(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Ticket Portal Manager - Operation: Select Tickets", instanceId);
        ticketPortalManagerService.selectTickets(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/requestCheckout/{instanceId}")
    public ResponseEntity<String> requestCheckout(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Ticket Portal Manager - Operation: Request Checkout", instanceId);
        ticketPortalManagerService.requestCheckout(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/checkoutComplete/{instanceId}")
    public ResponseEntity<String> checkoutComplete(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Ticket Portal Manager - Operation: Checkout Complete", instanceId);
        ticketPortalManagerService.checkoutComplete(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketIssueCompleted/{instanceId}")
    public ResponseEntity<String> ticketIssueCompleted(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Ticket Portal Manager - Operation: TicketIssueCompleted", instanceId);
        ticketPortalManagerService.ticketIssueCompleted(instanceId);
        return ResponseEntity.ok(response);
    }
}
