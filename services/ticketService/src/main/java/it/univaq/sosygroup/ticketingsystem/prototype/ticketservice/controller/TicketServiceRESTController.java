package it.univaq.sosygroup.ticketingsystem.prototype.ticketservice.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.ticketservice.business.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketServiceRESTController {

    private final TicketService ticketService;

    public TicketServiceRESTController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/createTickets/{instanceId}")
    public ResponseEntity<String> createTickets(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Ticket Service - Operation: Create Tickets", instanceId);
        ticketService.createTickets(instanceId);
        return ResponseEntity.ok(response);
    }

}
