package it.univaq.sosygroup.ticketingsystem.prototype.customer.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRESTController {

    private final CustomerService service;

    public CustomerRESTController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/ticketsReserved/{instanceId}")
    public ResponseEntity<?> ticketsReserved(@PathVariable String instanceId) {
        service.ticketsReserved(instanceId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/returnTicketsAndShippingInfo/{instanceId}")
    public ResponseEntity<?> returnTicketsAndShippingInfo(@PathVariable String instanceId) {
        service.returnTicketsAndShippingInfo(instanceId);

        return ResponseEntity.ok().build();
    }
}
