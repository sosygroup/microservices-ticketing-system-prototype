package it.univaq.sosygroup.ticketingsystem.prototype.printservice.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.printservice.business.PrintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintServiceRESTController {

    private final PrintService printService;

    public PrintServiceRESTController(PrintService printService) {
        this.printService = printService;
    }

    @GetMapping("/printTickets/{instanceId}")
    public ResponseEntity<String> printTickets(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Print Service - Operation: Print Tickets", instanceId);
        printService.printTickets(instanceId);
        return ResponseEntity.ok(response);
    }

}
