package it.univaq.sosygroup.ticketingsystem.prototype.customer.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRESTController {

    private final CustomerService service;

    public ClientRESTController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/invokeGetEventsList/{instanceId}")
    public ResponseEntity<?> invokeGetEventsList(@PathVariable String instanceId) {
        service.getEventsList(instanceId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/invokeGetEventInfo/{instanceId}")
    public ResponseEntity<?> invokeGetEventInfo(@PathVariable String instanceId) {
        service.getEventInfo(instanceId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/invokeSelectTickets/{instanceId}")
    public ResponseEntity<?> invokeSelectTickets(@PathVariable String instanceId) {
        service.selectTickets(instanceId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/invokeRequestCheckout/{instanceId}")
    public ResponseEntity<?> invokeRequestCheckout(@PathVariable String instanceId) {
        service.requestCheckout(instanceId);

        return ResponseEntity.ok().build();
    }
}
