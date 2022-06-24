package it.univaq.sosygroup.ticketingsystem.prototype.ticketingmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.ticketingmanager.business.TicketingManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketingManagerRESTController {

    private final TicketingManagerService ticketingManagerService;

    public TicketingManagerRESTController(TicketingManagerService ticketingManagerService) {
        this.ticketingManagerService = ticketingManagerService;
    }

    @GetMapping("/issueTickets/{instanceId}")
    public ResponseEntity<String> issuetickets(@PathVariable String instanceId) {
        String response = ticketingManagerService.issueTickets(instanceId);
        return ResponseEntity.ok(response);
    }

}
